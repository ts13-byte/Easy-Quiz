package com.exam.examServer.exceptions;

public class UserFoundException extends Exception {

	 public UserFoundException() {
	        super("user with this name is already present in the DB!");
	    }

	    public UserFoundException(String message) {
	        super(message);
	    }
}
