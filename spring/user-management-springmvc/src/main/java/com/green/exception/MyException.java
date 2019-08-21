package com.green.exception;

public class MyException extends Exception {
	private String message;
	
	public MyException() {
		// TODO Auto-generated constructor stub
	}
	
	public MyException(String msg) {
		this.message = msg;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
