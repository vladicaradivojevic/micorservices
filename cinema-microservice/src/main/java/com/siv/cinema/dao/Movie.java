package com.siv.cinema.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	private String genre;
	
	private String description;
}
