package com.siv.cinema.dto;

public class CinemaDto {

	private final Long id;

	private final String name;
	
	private final String location;

	public CinemaDto(Long id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	public CinemaDto(String name, String location) {
		this.id = null;
		this.name = name;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public static CinemaDto of(String name, String location) {
		return new CinemaDto(name, location);
	}
}
