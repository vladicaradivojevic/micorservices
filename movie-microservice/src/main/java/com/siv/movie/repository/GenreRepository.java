package com.siv.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siv.movie.dao.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}
