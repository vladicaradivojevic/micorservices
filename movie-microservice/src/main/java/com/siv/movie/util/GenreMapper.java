package com.siv.movie.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.siv.movie.dao.Genre;
import com.siv.movie.dto.GenreDto;

@Mapper
public interface GenreMapper {
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    Genre toDao(GenreDto dto);
    
    GenreDto toDto(Genre dao);
 
	List<GenreDto> toDto(List<Genre> list);
}