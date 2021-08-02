package com.alberto.spring.eureka.retrieve.transaction.api.model;

public class TreatedTransaction {
	private String transactionType;
	private String descripcion;
	private String date;
	private String amount;
	
	public TreatedTransaction() {}
	
	public TreatedTransaction(String transactionType, String descripcion, String date, String amount) {
		this.transactionType = transactionType;
		this.descripcion = descripcion;
		this.date = date;
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}

