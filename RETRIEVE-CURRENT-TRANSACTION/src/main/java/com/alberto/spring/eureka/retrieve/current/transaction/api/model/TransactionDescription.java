package com.alberto.spring.eureka.retrieve.current.transaction.api.model;

public class TransactionDescription {
	private String TransactionType;
	private String Descripcion;
	private String amount;
	
	public TransactionDescription() {}
	
	public TransactionDescription(String transactionType, String descripcion, String amount) {
		this.TransactionType = transactionType;
		this.Descripcion = descripcion;
		this.amount = amount;
	}

	public String getTransactionType() {
		return TransactionType;
	}

	public void setTransactionType(String transactionType) {
		this.TransactionType = transactionType;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.Descripcion = descripcion;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}
