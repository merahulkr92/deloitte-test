package com.www.urlshortener.exception;

import org.springframework.http.HttpStatus;

public class ShortenerException extends RuntimeException{

    
	private static final long serialVersionUID = 1L;
	private String key;
    private HttpStatus httpErrorCode;

    public ShortenerException(String key, HttpStatus httpErrorCode) {
        setKey(key);
        setHttpErrorCode(httpErrorCode);
    }

    public HttpStatus getHttpErrorCode() {
        return httpErrorCode;
    }

    private void setHttpErrorCode(HttpStatus httpErrorCode) {
        this.httpErrorCode = httpErrorCode;
    }

    public String getKey() {
        return key;
    }

    private void setKey(String key) {
        this.key = key;
    }
}