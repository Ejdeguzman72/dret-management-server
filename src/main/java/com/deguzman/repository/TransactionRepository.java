package com.deguzman.repository;

import java.util.List;

import com.deguzman.domain.Transaction;

public interface TransactionRepository {

	public List<Transaction> getAllTransactionInformation();
	
	public List<Transaction> getTransactionsByType(int transactionTypeId);
	
	public List<Transaction> getTransactionsByProperty(long propertyId);
	
	public int addTransactionInformation(Transaction transactionInfo);
	
	public int updateTransactionInformation(long transactionId, Transaction transactionDetails);
	
}
