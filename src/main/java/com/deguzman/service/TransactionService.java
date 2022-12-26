package com.deguzman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deguzman.domain.AppConstants;
import com.deguzman.domain.Transaction;
import com.deguzman.domain.TrxAddRequest;
import com.deguzman.domain.TrxAddResponse;
import com.deguzman.domain.TrxListResponse;
import com.deguzman.domain.TrxSearchByPropertyRequest;
import com.deguzman.domain.TrxSearchByTypeRequest;
import com.deguzman.domain.TrxUpdateRequest;
import com.deguzman.domain.TrxUpdateResponse;
import com.deguzman.dto.TransactionDTO;
import com.deguzman.repository.TransactionRepositoryImpl;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepositoryImpl trxRepositoryImpl;
	
	public TrxListResponse retrieveAllTransactions() {
		TrxListResponse response = new TrxListResponse();
		List<TransactionDTO> list = trxRepositoryImpl.getAllTransactionInformation();
		
		response.setList(list);
		response.setCount(list.size());
		response.setDescription(AppConstants.GET_TRX_LIST_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_TRANSACTION_LIST_MSG);
		
		return response;
	}
	
	public TrxListResponse searchTransactionsByType(TrxSearchByTypeRequest request) {
		TrxListResponse response = new TrxListResponse();
		List<TransactionDTO> list = trxRepositoryImpl.getTransactionsByProperty(request.getTrxTypeId());
		
		response.setList(list);
		response.setCount(list.size());
		response.setDescription(AppConstants.SEARCH_TRANSACTION_BY_TYPE_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.SEARCH_TRANSACTION_BY_TYPE_MSG);
		
		return response;
	}
	
	public TrxListResponse searchTransactionsByProperty(TrxSearchByPropertyRequest request) {
		TrxListResponse response = new TrxListResponse();
		List<TransactionDTO> list = trxRepositoryImpl.getTransactionsByProperty(request.getPropertyId());
		
		response.setList(list);
		response.setCount(list.size());
		response.setDescription(AppConstants.SEARCH_TRANSACTION_BY_PROEPRTY_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.SEARCH_TRANSACTION_BY_PROPERTY_MSG);
		
		return response;
	}
	
	public TrxAddResponse saveTransactionInformation(TrxAddRequest request) {
		TrxAddResponse response = new TrxAddResponse();
		Transaction transaction = new Transaction();
		int recordsAdded = trxRepositoryImpl.addTransactionInformation(request);
		
		if (request != null) {
			transaction.setAmount(request.getAmount());
			transaction.setPropertyId(request.getPropertyId());
			transaction.setSettlementDate(request.getSettlementDate());
			transaction.setTransactionTypeId(request.getTransactionTypeId());
			transaction.setVerified(request.isVerified());
		}
		
		response.setTransaction(transaction);
		response.setRecordsAdded(recordsAdded);
		response.setDescription(AppConstants.ADD_TRANSACTION_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.ADD_TRANSACTION_INFORMATION_MSG);
		
		return response;
	}
	
	public TrxUpdateResponse updateTransactionInformation(TrxUpdateRequest request) {
		TrxUpdateResponse response = new TrxUpdateResponse();
		Transaction updatedTrx = trxRepositoryImpl.searchTransactionById(request.getTransactionId());
		int updatedRecords = trxRepositoryImpl.updateTransactionInformation(request.getTransactionId(), request);
		
		response.setTransaction(updatedTrx);
		response.setRecordsUpdated(updatedRecords);
		response.setDescription(AppConstants.UPDATE_TRANSACTION_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.UPDATE_TRANSACTION_INFORMATION_MSG);
		
		return response;
	}
}