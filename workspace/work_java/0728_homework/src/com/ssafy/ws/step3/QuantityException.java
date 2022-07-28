package com.ssafy.ws.step3;

public class QuantityException extends RuntimeException {
	
	public QuantityException() {
		super();
	}

	public QuantityException(String message) {
		super(message);
	}

	public QuantityException(String message, Throwable cause) {
		super(message, cause);
	}

	public QuantityException(Throwable cause) {
		super(cause);
	}
}
