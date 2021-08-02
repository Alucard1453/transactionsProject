package com.alberto.spring.eureka.retrieve.current.transaction.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.alberto.spring.eureka.retrieve.current.transaction.api.model.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
	List<Transaction> findByCustomerId(int customerId);
}
