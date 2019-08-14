package com.green.spring;

public class HelloWorld {
	private String message;
	
	public void init() {
		
	}
	
	public void destroy() {
		
	}
	
	public HelloWorld() {
		// TODO Auto-generated constructor stub
	}
	
	public HelloWorld(String msg, String msg2) {
		this.message = msg.toUpperCase() + msg2.toUpperCase();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
