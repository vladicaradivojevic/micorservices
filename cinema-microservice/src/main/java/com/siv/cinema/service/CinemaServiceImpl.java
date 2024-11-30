package com.siv.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.siv.cinema.dao.Cinema;
import com.siv.cinema.dao.Movie;
import com.siv.cinema.dto.CinemaDto;
import com.siv.cinema.dto.MovieDto;
import com.siv.cinema.mapper.CinemaAdapter;
import com.siv.cinema.mapper.MovieAdapter;
import com.siv.cinema.repository.CinemaRepository;
import com.siv.cinema.repository.MovieRepository;

@Service
public class CinemaServiceImpl implements CinemaService {

	private final CinemaRepository cinemaRepository;
	private final MovieRepository movieRepository;

	
	@Autowired
	private CinemaServiceImpl(CinemaRepository cinemaRepository, MovieRepository movieRepository) {
		this.cinemaRepository = cinemaRepository;
		this.movieRepository = movieRepository;
	}
	
	@Override
	public CinemaDto findCinema(long id) {
		return CinemaAdapter.transform(cinemaRepository.findById(id).orElseThrow());
	}

	@Override
	public CinemaDto createCinema(CinemaDto cinema) {
		return CinemaAdapter.transform(cinemaRepository.save(CinemaAdapter.transform(cinema)));
	}

	@Override
	public void deleteCinema(long id) {
		cinemaRepository.deleteById(id);
	}

	@Override
	public List<CinemaDto> getCinemaList() {
		return CinemaAdapter.transform(cinemaRepository.findAll());
	}

	@Override
	public CinemaDto findCinemaByName(String name) {
		Cinema probe = new Cinema();
		probe.setName(name);
		return CinemaAdapter.transform(cinemaRepository.findOne(Example.of(probe)).orElseThrow());
	}

	@Override
	public MovieDto addMovie(MovieDto movieDto) {
		if (movieDto.getId() != null) {
			movieDto.setId(null);
		}
		
		Movie movie = MovieAdapter.transform(movieDto);
		movie = movieRepository.save(movie);
		return MovieAdapter.transform(movie);
	}
	
	
}
