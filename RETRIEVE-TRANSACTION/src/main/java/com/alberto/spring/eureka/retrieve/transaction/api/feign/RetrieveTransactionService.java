package com.alberto.spring.eureka.retrieve.transaction.api.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alberto.spring.eureka.retrieve.transaction.api.model.OptionsRequestBuild;
import com.alberto.spring.eureka.retrieve.transaction.api.model.Transaction;

@FeignClient("RETRIEVE-CURRENT-TRANSACTION")
@RequestMapping("/")
public interface RetrieveTransactionService {
	@PostMapping("retrieve-current-transaction")
	public List<Transaction> getResponse(@RequestBody OptionsRequestBuild optionsRequestBuild);
}
