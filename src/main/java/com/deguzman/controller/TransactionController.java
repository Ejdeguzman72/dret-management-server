package com.deguzman.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.domain.ContactAddRequest;
import com.deguzman.domain.ContactAddResponse;
import com.deguzman.domain.ContactDeleteRequest;
import com.deguzman.domain.ContactDeleteResponse;
import com.deguzman.domain.ContactListResponse;
import com.deguzman.domain.ContactSearchByNameRequest;
import com.deguzman.domain.ContactSearchByTypeRequest;
import com.deguzman.domain.ContactUpdateRequest;
import com.deguzman.domain.ContactUpdateResponse;
import com.deguzman.domain.SuccessResponse;
import com.deguzman.domain.TrxAddRequest;
import com.deguzman.domain.TrxAddResponse;
import com.deguzman.domain.TrxListResponse;
import com.deguzman.domain.TrxSearchByPropertyRequest;
import com.deguzman.domain.TrxSearchByTypeRequest;
import com.deguzman.domain.TrxUpdateRequest;
import com.deguzman.domain.TrxUpdateResponse;
import com.deguzman.domain.UriConstants;
import com.deguzman.service.TransactionService;

@RestController
@CrossOrigin
public class TransactionController {

	@Autowired
	private TransactionService trxService;
	
	@GetMapping(value = UriConstants.GET_ALL_TRX_URI)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<TrxListResponse>> getAllPersonInfo() throws SecurityException, IOException {
		TrxListResponse response = trxService.retrieveAllTransactions();
		
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.GET_ALL_TRX_BY_TYPE_URI)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<TrxListResponse>> getPersonInformationByType(@RequestBody TrxSearchByTypeRequest request) {
		TrxListResponse response =  trxService.searchTransactionsByType(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@GetMapping(value = UriConstants.GET_ALL_TRX_BY_PROPERTY_URI)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<TrxListResponse>> getPersonInformationByProperty(@RequestBody TrxSearchByPropertyRequest request) {
		TrxListResponse response =  trxService.searchTransactionsByProperty(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@PostMapping(value = UriConstants.ADD_TRX_INFORMATION_URI)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<TrxAddResponse>> saveContactInformation(@RequestBody TrxAddRequest request) throws SecurityException, IOException {
		TrxAddResponse response = trxService.saveTransactionInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@PutMapping(value = UriConstants.UPDATE_TRX_INFORMATION_URI)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<TrxUpdateResponse>> updateContactInformation(@RequestBody TrxUpdateRequest request) throws SecurityException, IOException {
		TrxUpdateResponse response = trxService.updateTransactionInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
}
