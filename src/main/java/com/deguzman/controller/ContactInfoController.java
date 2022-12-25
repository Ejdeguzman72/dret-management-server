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
import com.deguzman.domain.UriConstants;
import com.deguzman.service.ContactService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ContactInfoController {

	@Autowired
	private ContactService contactInfoService;

	@GetMapping(value = UriConstants.GET_ALL_CONTACTS_URI)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<ContactListResponse>> getAllPersonInfo() throws SecurityException, IOException {
		ContactListResponse response = contactInfoService.getAllContacts();
		
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.GET_ALL_CONTACTS_BY_TYPE_URI)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<ContactListResponse>> getPersonInformationByType(@RequestBody ContactSearchByTypeRequest request) {
		ContactListResponse response =  contactInfoService.searchContactsByType(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@GetMapping(value = UriConstants.GET_ALL_CONTACTS_BY_NAME_URI)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<ContactListResponse>> getPersonInformationByName(@RequestBody ContactSearchByNameRequest request) {
		ContactListResponse response =  contactInfoService.searchContactsByName(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@PostMapping(value = UriConstants.ADD_CONTACT_INFORMATION_URI)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<ContactAddResponse>> saveContactInformation(@RequestBody ContactAddRequest request) throws SecurityException, IOException {
		ContactAddResponse response = contactInfoService.addContactInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@PutMapping(value = UriConstants.UPDATE_CONTACT_INFORMATION_URI)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<ContactUpdateResponse>> updateContactInformation(@RequestBody ContactUpdateRequest request) throws SecurityException, IOException {
		ContactUpdateResponse response = contactInfoService.updateContactInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}


	@DeleteMapping(value = UriConstants.DELETE_CONTACT_INFORMATION_URI)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<ContactDeleteResponse>> deleteContactInformation(@RequestBody ContactDeleteRequest request) throws SecurityException, IOException {
		ContactDeleteResponse response = contactInfoService.deleteContactInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
}
