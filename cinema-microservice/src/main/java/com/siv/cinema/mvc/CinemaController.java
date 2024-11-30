package com.siv.cinema.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siv.cinema.dto.CinemaDto;
import com.siv.cinema.service.CinemaService;

@RestController
@RequestMapping(value = "/api/v1/cinema")
public class CinemaController {
	
	@Autowired
	private CinemaService cinemaService;

	@GetMapping
	public List<CinemaDto> getCinemas() {
		return cinemaService.getCinemaList();
	}
	
	@GetMapping("/{id}")
	public CinemaDto findCinema(long id) {
		return cinemaService.findCinema(id);
	}
	
	@PostMapping
	public CinemaDto createCinema(String name, String location) {
		CinemaDto cinema = CinemaDto.of(name, location);
		return cinemaService.createCinema(cinema);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCinema(Long id) {
		cinemaService.deleteCinema(id);
	}
}
