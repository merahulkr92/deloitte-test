package com.www.urlshortener.exception;

import org.springframework.http.HttpStatus;

public class UnknownUrlException extends ShortenerException {

	private static final long serialVersionUID = 1L;

	public UnknownUrlException() {
		super("UNKNOWN_URL", HttpStatus.NOT_FOUND);
	}

}