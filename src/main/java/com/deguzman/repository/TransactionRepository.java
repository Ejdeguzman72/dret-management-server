package com.deguzman.repository;

import java.util.List;

import com.deguzman.domain.Transaction;
import com.deguzman.dto.TransactionDTO;

public interface TransactionRepository {

	public List<TransactionDTO> getAllTransactionInformation();
	
	public List<TransactionDTO> getTransactionsByType(int transactionTypeId);
	
	public List<TransactionDTO> getTransactionsByProperty(long propertyId);
	
	public int addTransactionInformation(Transaction transactionInfo);
	
	public int updateTransactionInformation(long transactionId, Transaction transactionDetails);
	
}
