package com.alberto.spring.eureka.retrieve.current.transaction.api.exceptions.custom;

public class EmptyFieldException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3259849067615956755L;
	private int errorCode;
	private String errorType;
	
	public EmptyFieldException(int errorCode, String errorInfo) {
		super(errorInfo);
		this.errorType = "EmptyFieldException";
		this.errorCode = errorCode;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	
	public String getErrorType() {
		return errorType;
	}
}
