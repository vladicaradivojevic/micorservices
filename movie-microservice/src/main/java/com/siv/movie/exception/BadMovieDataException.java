package com.siv.movie.exception;

public class BadMovieDataException extends IllegalStateException {

	private static final long serialVersionUID = 1L;


	public BadMovieDataException(String string) {
		super(string);
	}
}
