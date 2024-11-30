package com.siv.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.siv.movie.dto.GenreDto;

@Service
public interface GenreService {
	
	List<GenreDto> getGenreList();

	GenreDto findGenre(long id);
	
	GenreDto createGenre(GenreDto genre);
	
	void deleteGenre(long id);

}
