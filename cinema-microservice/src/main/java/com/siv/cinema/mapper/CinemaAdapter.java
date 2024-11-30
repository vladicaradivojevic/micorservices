package com.siv.cinema.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.siv.cinema.dao.Cinema;
import com.siv.cinema.dto.CinemaDto;

public class CinemaAdapter {

	public static Cinema transform(CinemaDto cinemaDto) {
		return new Cinema(cinemaDto.getId(), cinemaDto.getName(), cinemaDto.getLocation());
	}

	public static CinemaDto transform(Cinema cinema) {
		return new CinemaDto(cinema.getId(), cinema.getName(), cinema.getLocation());
	}

	public static List<CinemaDto> transform(List<Cinema> cinema) {
		return cinema.stream().map(u -> transform(u)).collect(Collectors.toList());
	}
}
