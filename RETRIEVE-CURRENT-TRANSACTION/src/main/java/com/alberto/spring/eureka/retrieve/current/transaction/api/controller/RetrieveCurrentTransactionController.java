package com.alberto.spring.eureka.retrieve.current.transaction.api.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

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
			List<Transaction> values = new LinkedList<>();
			values = transactionRepository.findByCustomerId( Integer.parseInt(request.getCustomerId()) );
			values.stream().forEach((Transaction transaction)->{
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate parsedDateStart = LocalDate.parse(request.getTransactionDateStart(), formatter);
				LocalDate parsedDateEnd = LocalDate.parse(request.getTransactionDateEnd(), formatter);
				LocalDate parsedDateTransaction = LocalDate.parse(transaction.getDate(), formatter);
				if(parsedDateTransaction.compareTo(parsedDateStart) >= 0 && parsedDateTransaction.compareTo(parsedDateEnd) <= 0)
					response.add(transaction);
			});
		}
		return response;
		//return transactionRepository.findAll();
	}
}
