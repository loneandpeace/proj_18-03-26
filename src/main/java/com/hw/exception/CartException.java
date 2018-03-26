package com.hw.exception;

public class CartException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7173006932851201808L;
	public CartException() {}
	public CartException(String message) {
		super(message);
	}
}
