package com.siv.movie.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siv.movie.dto.GenreDto;
import com.siv.movie.dto.MovieDto;
import com.siv.movie.service.GenreService;
import com.siv.movie.service.MovieService;

@RestController
@RequestMapping(value = "/api/v1/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private GenreService genreService;
	
	@GetMapping
	public List<MovieDto> getMovies() {
		return movieService.getMovieList();
	}
	
	@GetMapping("/{id}")
	public MovieDto findMovie(@PathVariable(name = "id") long id) {
		return movieService.findMovie(id);
	}
	
	@PostMapping
	public MovieDto createMovie(@RequestParam String title, @RequestParam String description, @RequestParam (required = false) Integer genreId) {
		MovieDto movie = MovieDto.builder().title(title).description(description).build();
		
		GenreDto genre = genreService.findGenre(genreId);
		movie.getGenreList().add(genre);
		
		return movieService.createMovie(movie);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMovie(Long id) {
		movieService.deleteMovie(id);
	}
}
