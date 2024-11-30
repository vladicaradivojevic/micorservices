package com.siv.cinema.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.siv.cinema.dao.Movie;
import com.siv.cinema.dto.MovieDto;

public class MovieAdapter {

	public static Movie transform(MovieDto movieDto) {
		return new Movie(movieDto.getId(), movieDto.getTitle(), movieDto.getGenre(), movieDto.getDescription());
	}

	public static MovieDto transform(Movie movie) {
		return new MovieDto(movie.getId(), movie.getTitle(), movie.getGenre(), movie.getDescription());
	}

	public static List<MovieDto> transform(List<Movie> movie) {
		return movie.stream().map(u -> transform(u)).collect(Collectors.toList());
	}
}
