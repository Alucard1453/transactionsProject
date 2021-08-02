package com.alberto.spring.eureka.retrieve.current.transaction.api.exceptions.custom;

public class InvalidFieldException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8053594298667226467L;
	private int errorCode;
	private String errorType;
	
	public InvalidFieldException(int errorCode, String errorInfo) {
		super(errorInfo);
		this.errorType = "InvalidFieldException";
		this.errorCode = errorCode;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	
	public String getErrorType() {
		return errorType;
	}
}
