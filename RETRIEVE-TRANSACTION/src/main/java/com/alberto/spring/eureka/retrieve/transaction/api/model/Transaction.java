package com.alberto.spring.eureka.retrieve.transaction.api.model;

public class Transaction {
	private int customerId;
	private String date;
	private TransactionDescription transactionDescription;
	
	public Transaction() {}
	
	public Transaction(int customerId, String date, TransactionDescription transactionDescription) {
		this.customerId = customerId;
		this.date = date;
		this.transactionDescription = transactionDescription;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public TransactionDescription getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(TransactionDescription transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
}
