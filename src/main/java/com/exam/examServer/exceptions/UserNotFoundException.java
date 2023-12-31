package com.exam.examServer.exceptions;

public class UserNotFoundException extends Exception {
	
	 public UserNotFoundException() {
	        super("user with this name cannot be found!");
	    }

	    public UserNotFoundException(String message) {
	        super(message);
	    }

	    public UserNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }

	    public UserNotFoundException(Throwable cause) {
	        super(cause);
	    }
}
