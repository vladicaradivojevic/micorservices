package com.siv.movie.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.siv.movie.dao.Movie;
import com.siv.movie.dto.MovieDto;

@Mapper
public interface MovieMapper {
	MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
	
    Movie toDao(MovieDto dto);
    
    MovieDto toDto(Movie dao);
 
	List<MovieDto> toDto(List<Movie> list);
}