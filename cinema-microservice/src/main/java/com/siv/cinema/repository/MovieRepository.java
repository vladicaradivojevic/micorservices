package com.siv.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siv.cinema.dao.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
