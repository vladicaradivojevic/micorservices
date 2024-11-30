package com.siv.movie.dao;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Movie {
	
	@Id
	@GeneratedValue
	private Long id;

	private String title;
	
	private String description;

	@Builder.Default
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "movie_genre", 
		joinColumns = @JoinColumn(name = "movie_id"), 
		inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private Set<Genre> genreList = new HashSet<>();
}
