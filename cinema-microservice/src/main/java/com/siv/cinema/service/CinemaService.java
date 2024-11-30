package com.siv.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.siv.cinema.dto.CinemaDto;
import com.siv.cinema.dto.MovieDto;

@Service
public interface CinemaService {
	
	List<CinemaDto> getCinemaList();

	CinemaDto findCinema(long id);
	
	CinemaDto createCinema(CinemaDto cinema);
	
	MovieDto addMovie(MovieDto movie);
	
	void deleteCinema(long id);

	CinemaDto findCinemaByName(String name);
}
