package com.siv.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import com.siv.common.Event;
import com.siv.common.EventType;
import com.siv.common.EventTopic;
import com.siv.common.messaging.MessageProducer;
import com.siv.movie.dao.Movie;
import com.siv.movie.dto.GenreDto;
import com.siv.movie.dto.MovieDto;
import com.siv.movie.exception.BadMovieDataException;
import com.siv.movie.repository.MovieRepository;
import com.siv.movie.util.GenreMapper;
import com.siv.movie.util.MovieMapper;

import jakarta.transaction.Transactional;

@Service
public class MovieServiceImpl implements MovieService {

	private final MovieRepository repository;

	private final MessageProducer messageProducer;
	
	@Autowired
	public MovieServiceImpl(MovieRepository repository, MessageProducer messageProducer) {
		this.repository = repository;
		this.messageProducer = messageProducer;
	}
	
	@Override
	public MovieDto findMovie(long id) {
		return MovieMapper.INSTANCE.toDto(repository.findById(id).orElseThrow());
	}

	@Transactional
	@Override
	public MovieDto createMovie(MovieDto movieDto) {
		validateMovie(movieDto, true);
		Movie movie = MovieMapper.INSTANCE.toDao(movieDto);
		movieDto = MovieMapper.INSTANCE.toDto(repository.save(movie));
		sendMovieMessage(EventType.CREATE, movieDto);
		return movieDto;
	}

	private void validateMovie(MovieDto movie, boolean isNewMovie) {
		if (!isNewMovie) {
			if (movie == null || movie.getId() == null || movie.getId() < 1 || !repository.existsById(movie.getId())) {
				throw new BadMovieDataException("Target movie not found by id");
			}
		} else {
			
			if (movie == null || movie.getId() != null || movie.getTitle() == null || movie.getGenreList() == null || movie.getGenreList().isEmpty()) {
				throw new BadMovieDataException("The movie could not be added");
			}
		}
	}

	@Transactional
	@Override
	public void deleteMovie(long id) {
		MovieDto movie = findMovie(id);
		if (movie != null) {
			sendMovieMessage(EventType.DELETE, movie);
			repository.deleteById(id);
		} else {
			throw new IllegalStateException("The movie with id " + id + " does not exist");
		}
	}

	private void sendMovieMessage(EventType action, MovieDto movie) {
		messageProducer.sendMessage(EventTopic.MOVIE, Event.of(action, movie));
	}

	@Override
	public List<MovieDto> getMovieList() {
		return MovieMapper.INSTANCE.toDto(repository.findAll());
	}

	@EntityGraph(attributePaths = {"genres"})
	@Override
	public MovieDto findMovieByName(String title) {
		Movie probe = new Movie();
		probe.setTitle(title);
		return MovieMapper.INSTANCE.toDto(repository.findOne(Example.of(probe)).orElseThrow());
	}
	
	@Override
	public MovieDto findMovieByGenre(GenreDto genre) {
		Movie probe = new Movie();
		probe.getGenreList().add(GenreMapper.INSTANCE.toDao(genre));
		return MovieMapper.INSTANCE.toDto(repository.findOne(Example.of(probe)).orElseThrow());
	}
		
}
