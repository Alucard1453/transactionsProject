package com.alberto.spring.eureka.retrieve.transaction.api.model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.alberto.spring.eureka.retrieve.transaction.api.exceptions.ErrorType;
import com.alberto.spring.eureka.retrieve.transaction.api.exceptions.custom.EmptyFieldException;
import com.alberto.spring.eureka.retrieve.transaction.api.exceptions.custom.InvalidFieldException;

public class OptionsRequest {
	private String accountId;
	private String branchId;
	private String transactionDateStart;
	private String transactionDateEnd;
	
	public OptionsRequest() {}
	
	public OptionsRequest(String accountId, String branchId, String transactionDateStart, String transactionDateEnd) {
		this.accountId = accountId;
		this.branchId = branchId;
		this.transactionDateStart = transactionDateStart;
		this.transactionDateEnd = transactionDateEnd;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
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
		validateAccountId();
		validatebranchId();
		validatetransactionDateStart();
		validatetransactionDateEnd();
		return true;
	}

	private void validateAccountId() {
		if( accountId == null || accountId.isBlank() )
			throw new EmptyFieldException(ErrorType.VALIDATION_EMPTY_FIELDS_ERROR.getCode(), "The field accountId can't be null");
		else if( accountId.length() < 3 )
			throw new InvalidFieldException(ErrorType.VALIDATION_LENGHT_FIELDS_ERROR.getCode(), "The length of accountId field is invalid");
		else {
			try {
	            Integer.parseInt(accountId);
	        } catch (NumberFormatException excepcion) {
	        	throw new InvalidFieldException(ErrorType.VALIDATION_LENGHT_FIELDS_ERROR.getCode(), "The accountId field is not an Integer number so is invalid");
	        }
		}
	}

	private void validatebranchId() {
		if( branchId == null || branchId.isBlank() )
			throw new EmptyFieldException(ErrorType.VALIDATION_EMPTY_FIELDS_ERROR.getCode(), "The field branchId can't be null");
		else if( branchId.length() < 3 )
			throw new InvalidFieldException(ErrorType.VALIDATION_LENGHT_FIELDS_ERROR.getCode(), "The length of branchId field is invalid");
		else {
			try {
	            Integer.parseInt(branchId);
	        } catch (NumberFormatException excepcion) {
	        	throw new InvalidFieldException(ErrorType.VALIDATION_LENGHT_FIELDS_ERROR.getCode(), "The branchId field is not an Integer number so is invalid");
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
