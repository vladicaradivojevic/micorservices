package com.siv.movie.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MovieDto {

	private Long id;

	private String title;
	
	private String description;
	
	@Builder.Default
	private Set<GenreDto> genreList = new HashSet<>();
}
