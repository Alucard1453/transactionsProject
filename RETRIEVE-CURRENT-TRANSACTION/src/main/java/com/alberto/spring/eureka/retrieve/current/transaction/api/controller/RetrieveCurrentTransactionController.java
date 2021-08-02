package com.alberto.spring.eureka.retrieve.current.transaction.api.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alberto.spring.eureka.retrieve.current.transaction.api.repository.TransactionRepository;
import com.alberto.spring.eureka.retrieve.current.transaction.api.model.OptionsRequest;
import com.alberto.spring.eureka.retrieve.current.transaction.api.model.Transaction;

@RestController
public class RetrieveCurrentTransactionController {
	@Autowired
	private TransactionRepository transactionRepository;
	
	@PostMapping("/retrieve-current-transaction")
	public List<Transaction> searchTransactions(@RequestBody OptionsRequest request) {
		List<Transaction> response = new LinkedList<>();
		if(request.validateFields()) {
			List<Transaction> values = transactionRepository.findByCustomerId( Integer.parseInt(request.getCustomerId()) );
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate parsedDateStart = LocalDate.parse(request.getTransactionDateStart(), formatter);
			LocalDate parsedDateEnd = LocalDate.parse(request.getTransactionDateEnd(), formatter);
			
			response = (List<Transaction>) values.stream().filter( (Transaction transaction) -> 
				parsedDateStart.isBefore(LocalDate.parse(transaction.getDate(), formatter)) &&
				parsedDateEnd.isAfter(LocalDate.parse(transaction.getDate(), formatter)) ||
				parsedDateStart.isEqual(LocalDate.parse(transaction.getDate(), formatter)) ||
				parsedDateEnd.isEqual(LocalDate.parse(transaction.getDate(), formatter))).collect(Collectors.toList());
		}
		return response;
		//return transactionRepository.findAll();
	}
}
