package com.alberto.spring.eureka.retrieve.current.transaction.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Transactions")
public class Transaction {
	@Id
	private String id;
	private int customerId;
	private String date;
	private TransactionDescription transactionDescription;
	
	public Transaction() {}
	
	public Transaction(int customerId, String date, TransactionDescription transactionDescription) {
		this.customerId = customerId;
		this.date = date;
		this.transactionDescription = transactionDescription;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
