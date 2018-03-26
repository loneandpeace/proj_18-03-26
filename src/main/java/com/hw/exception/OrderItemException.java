package com.hw.exception;

public class OrderItemException extends RuntimeException {
	public OrderItemException() {}
	public OrderItemException(String message) {
		super(message);
	}
}
