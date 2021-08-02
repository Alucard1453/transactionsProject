package com.alberto.spring.eureka.retrieve.current.transaction.api.exceptions;

public enum ErrorType {
	VALIDATION_EMPTY_FIELDS_ERROR(400),
	VALIDATION_LENGHT_FIELDS_ERROR(406),
	VALIDATION_VALID_FIELDS_ERROR(406);

	private int code;

	ErrorType(int code) {
		this.code=code;
	}
	
	public int getCode() {
		return code;
	}
	
}
