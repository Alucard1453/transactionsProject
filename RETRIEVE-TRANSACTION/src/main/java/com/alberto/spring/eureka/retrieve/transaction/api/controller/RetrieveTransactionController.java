package com.alberto.spring.eureka.retrieve.transaction.api.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alberto.spring.eureka.retrieve.transaction.api.feign.RetrieveTransactionService;
import com.alberto.spring.eureka.retrieve.transaction.api.model.OptionsRequest;
import com.alberto.spring.eureka.retrieve.transaction.api.model.OptionsRequestBuild;
import com.alberto.spring.eureka.retrieve.transaction.api.model.Transaction;
import com.alberto.spring.eureka.retrieve.transaction.api.model.TreatedTransaction;

@RestController
public class RetrieveTransactionController {
	@Autowired
	private RetrieveTransactionService searchservice;
	
	@PostMapping("/retrieve-transaction-user")
	public ResponseEntity<?> searchTransactions(@RequestBody OptionsRequest request) {
		List<TreatedTransaction> transactions = new LinkedList<>();
		Map<String, List<TreatedTransaction>> respuesta = new HashMap<String, List<TreatedTransaction>>();
		if(request.validateFields()) {
			OptionsRequestBuild optionsRequestBuild = new OptionsRequestBuild();
			optionsRequestBuild.setCustomerId(
					request.getAccountId().substring(0, 3) + 
					request.getBranchId().substring(request.getBranchId().length()-3, 
					request.getBranchId().length()));
			optionsRequestBuild.setTransactionDateStart(request.getTransactionDateStart());
			optionsRequestBuild.setTransactionDateEnd(request.getTransactionDateEnd());
			List<Transaction> data = searchservice.getResponse(optionsRequestBuild);
			data.forEach((Transaction transaction)->{
				transactions.add(new TreatedTransaction(transaction.getTransactionDescription().getTransactionType(), transaction.getTransactionDescription().getDescripcion(), transaction.getDate(), transaction.getTransactionDescription().getAmount()));
			});
			respuesta.put("transactions", transactions);
		}
		if(transactions.size()>0)
			return new ResponseEntity<Map<String, List<TreatedTransaction>>>(respuesta, HttpStatus.OK);
		else
			return new ResponseEntity<>("No se encontraron movimientos dentro de los días de búsqueda.", HttpStatus.NOT_FOUND);
	}
}
