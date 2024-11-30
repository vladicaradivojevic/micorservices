package com.siv.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siv.movie.dto.GenreDto;
import com.siv.movie.repository.GenreRepository;
import com.siv.movie.util.GenreMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreRepository repository;

	@Override
	public GenreDto findGenre(long id) {
		return GenreMapper.INSTANCE.toDto(repository.findById(id).orElseThrow());
	}

	@Override
	public GenreDto createGenre(GenreDto genre) {
		return GenreMapper.INSTANCE.toDto(repository.save(GenreMapper.INSTANCE.toDao(genre)));
	}

	@Override
	public void deleteGenre(long id) {
		repository.deleteById(id);
	}

	@Override
	public List<GenreDto> getGenreList() {
		return GenreMapper.INSTANCE.toDto(repository.findAll());
	}
}
