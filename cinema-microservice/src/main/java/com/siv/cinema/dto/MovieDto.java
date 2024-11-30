package com.siv.cinema.dto;

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
	private String genre;
}
