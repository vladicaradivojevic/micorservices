package com.siv.movie.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siv.movie.dto.GenreDto;
import com.siv.movie.service.GenreService;

@RestController
@RequestMapping(value = "/api/v1/genre")
public class GenreController {
	
	@Autowired
	private GenreService genreService;

	@GetMapping
	public List<GenreDto> getGenres() {
		return genreService.getGenreList();
	}
	
	@GetMapping("/{id}")
	public GenreDto findGenre(long id) {
		return genreService.findGenre(id);
	}
	
	@PostMapping
	public GenreDto createGenre(String type) {
		GenreDto genre = GenreDto.builder().name(type).build();
		
		return genreService.createGenre(genre);
	}
	
	@DeleteMapping("/{id}")
	public void deleteGenre(Long id) {
		genreService.deleteGenre(id);
	}
}
