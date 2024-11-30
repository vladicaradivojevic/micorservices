package com.siv.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.siv.movie.dto.GenreDto;
import com.siv.movie.dto.MovieDto;

@Service
public interface MovieService {
	
	List<MovieDto> getMovieList();

	MovieDto findMovie(long id);
	
	MovieDto createMovie(MovieDto movie);
	
	void deleteMovie(long id);

	MovieDto findMovieByName(String movie);

	MovieDto findMovieByGenre(GenreDto genre);
}
