package com.ssafy.exception;

public class InvalidValueException extends RuntimeException {
	private int value;

	public InvalidValueException(int value) {
		super("값이 잘못 되었습니다. : " + value);
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
