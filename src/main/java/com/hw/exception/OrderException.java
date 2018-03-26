package com.hw.exception;

public class OrderException extends RuntimeException {
	public OrderException() {}
	public OrderException(String message) {
		super(message);
	}
}
