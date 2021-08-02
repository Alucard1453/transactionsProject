package com.alberto.spring.eureka.retrieve.current.transaction.api.model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.alberto.spring.eureka.retrieve.current.transaction.api.exceptions.custom.EmptyFieldException;
import com.alberto.spring.eureka.retrieve.current.transaction.api.exceptions.custom.InvalidFieldException;
import com.alberto.spring.eureka.retrieve.current.transaction.api.exceptions.ErrorType;

public class OptionsRequest {
	private String customerId;
	private String transactionDateStart;
	private String transactionDateEnd;
	
	public OptionsRequest() {}
	
	public OptionsRequest(String customerId, String transactionDateStart, String transactionDateEnd) {
		this.customerId = customerId;
		this.transactionDateStart = transactionDateStart;
		this.transactionDateEnd = transactionDateEnd;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getTransactionDateStart() {
		return transactionDateStart;
	}

	public void setTransactionDateStart(String transactionDateStart) {
		this.transactionDateStart = transactionDateStart;
	}

	public String getTransactionDateEnd() {
		return transactionDateEnd;
	}

	public void setTransactionDateEnd(String transactionDateEnd) {
		this.transactionDateEnd = transactionDateEnd;
	}
	
	public boolean validateFields() {
		validatecustomerId();
		validatetransactionDateStart();
		validatetransactionDateEnd();
		return true;
	}
	
	private void validatecustomerId() {
		if( customerId == null || customerId.isBlank() )
			throw new EmptyFieldException(ErrorType.VALIDATION_EMPTY_FIELDS_ERROR.getCode(), "The field customerId can't be null");
		else if( customerId.length() < 3 )
			throw new InvalidFieldException(ErrorType.VALIDATION_LENGHT_FIELDS_ERROR.getCode(), "The length of customerId field is invalid");
		else {
			try {
	            Integer.parseInt(customerId);
	        } catch (NumberFormatException excepcion) {
	        	throw new InvalidFieldException(ErrorType.VALIDATION_LENGHT_FIELDS_ERROR.getCode(), "The customerId field is not an Integer number so is invalid");
	        }
		}
	}

	private void validatetransactionDateStart() {
		if( transactionDateStart == null || transactionDateStart.isBlank() )
			throw new EmptyFieldException(ErrorType.VALIDATION_EMPTY_FIELDS_ERROR.getCode(), "The field transactionDateStart can't be null");
		else {
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				//LocalDate parsedDate = LocalDate.parse(transactionDateStart, formatter);
				LocalDate.parse(transactionDateStart, formatter);
			}catch (DateTimeException e) {
				throw new InvalidFieldException(ErrorType.VALIDATION_VALID_FIELDS_ERROR.getCode(), "The transactionDateStart field is not a date valid");
			}
		}
	}
	
	private void validatetransactionDateEnd() {
		if( transactionDateEnd == null || transactionDateEnd.isBlank() )
			throw new EmptyFieldException(ErrorType.VALIDATION_EMPTY_FIELDS_ERROR.getCode(), "The field transactionDateEnd can't be null");
		else {
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				//LocalDate parsedDate = LocalDate.parse(transactionDateStart, formatter);
				LocalDate.parse(transactionDateEnd, formatter);
			}catch (DateTimeException e) {
				throw new InvalidFieldException(ErrorType.VALIDATION_VALID_FIELDS_ERROR.getCode(), "The transactionDateEnd field is not a date valid");
			}
		}
	}
}
