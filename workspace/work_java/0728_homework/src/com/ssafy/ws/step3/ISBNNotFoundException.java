package com.ssafy.ws.step3;

public class ISBNNotFoundException extends RuntimeException {
	public ISBNNotFoundException() {
		super();
	}

	public ISBNNotFoundException(String message) {
		super(message);
	}

	public ISBNNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ISBNNotFoundException(Throwable cause) {
		super(cause);
	}
}
