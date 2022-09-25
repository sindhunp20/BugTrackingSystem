package com.code.exception;

public class ErrorInExecutionException extends Exception {

	private static final long serialVersionUID = 1L;

	public ErrorInExecutionException (String mesg) {
		super(mesg);
	}
}