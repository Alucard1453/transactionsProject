package com.alberto.spring.eureka.retrieve.transaction.api.model;

public class OptionsRequestBuild {
	private String customerId;
	private String transactionDateStart;
	private String transactionDateEnd;
	
	public OptionsRequestBuild() {}
	
	public OptionsRequestBuild(String customerId, String transactionDateStart, String transactionDateEnd) {
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
}
