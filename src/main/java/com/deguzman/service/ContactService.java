package com.deguzman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deguzman.domain.AppConstants;
import com.deguzman.domain.Contact;
import com.deguzman.domain.ContactAddRequest;
import com.deguzman.domain.ContactAddResponse;
import com.deguzman.domain.ContactDeleteRequest;
import com.deguzman.domain.ContactDeleteResponse;
import com.deguzman.domain.ContactListResponse;
import com.deguzman.domain.ContactSearchByNameRequest;
import com.deguzman.domain.ContactSearchByTypeRequest;
import com.deguzman.domain.ContactUpdateRequest;
import com.deguzman.domain.ContactUpdateResponse;
import com.deguzman.repository.ContactRepositoryImpl;

@Service
public class ContactService {

	@Autowired
	private ContactRepositoryImpl contactRepositoryImpl;
	
	public ContactListResponse getAllContacts() {
		ContactListResponse response = new ContactListResponse();
		List<Contact> list = contactRepositoryImpl.findAllContacts();
		
		response.setList(list);
		response.setCount(list.size());
		response.setDescription(AppConstants.GET_CONTACT_LIST_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_CONTACT_LIST_MSG);
		
		return response;
	}
	
	public ContactListResponse searchContactsByType(ContactSearchByTypeRequest request) {
		ContactListResponse response = new ContactListResponse();
		List<Contact> list = contactRepositoryImpl.findContactByType(request.getContactTypeId());
		
		response.setList(list);
		response.setCount(list.size());
		response.setDescription(AppConstants.SEARCH_CONTACT_BY_TYPE_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.SEARCH_CONTACT_BY_TYPE_MSG);
		
		return response;
	}
	
	public ContactListResponse searchContactsByName(ContactSearchByNameRequest request) {
		ContactListResponse response = new ContactListResponse();
		List<Contact> list = contactRepositoryImpl.findContactByName(request.getFirstname(), request.getLastname());
		
		response.setList(list);
		response.setCount(list.size());
		response.setDescription(AppConstants.SEARCH_CONTACT_BY_TYPE_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.SEARCH_CONTACT_BY_TYPE_MSG);
		
		return response;
	}
	
	public ContactAddResponse addContactInformation(ContactAddRequest request) {
		ContactAddResponse response = new ContactAddResponse();
		Contact contactInfo = new Contact();
		int recordsAdded = contactRepositoryImpl.addContactInformation(request);
		
		if (request != null) {
			contactInfo.setContactTypeId(request.getContactTypeId());
			contactInfo.setEmail(request.getEmail());
			contactInfo.setFirstname(request.getFirstname());
			contactInfo.setLastname(request.getLastname());
			contactInfo.setMiddleInitial(request.getMiddleInitial());
			contactInfo.setPhone(request.getPhone());			
		}
		
		response.setContact(contactInfo);
		response.setRecordsAdded(recordsAdded);
		response.setDescription(AppConstants.ADD_CONTACT_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.ADD_CONTACT_INFORMATION_MSG);
		
		return response;
	}
	
	public ContactUpdateResponse updateContactInformation(ContactUpdateRequest request) {
		ContactUpdateResponse response = new ContactUpdateResponse();
		Contact updatedContact = contactRepositoryImpl.searchContactById(request.getContactId());
		int updatedRecords = contactRepositoryImpl.updateContactInformation(request, request.getContactTypeId());
		
		response.setContact(updatedContact);
		response.setUpdatedReocrds(updatedRecords);
		response.setDescription(AppConstants.UPDATE_CONTACT_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.UPDATE_CONTACT_INFORMATION_MSG);
		
		return response;
	}
	
	public ContactDeleteResponse deleteContactInformation(ContactDeleteRequest request) {
		ContactDeleteResponse response = new ContactDeleteResponse();
		Contact contact = contactRepositoryImpl.searchContactById(request.getContactId());
		int deletedRecords = contactRepositoryImpl.deleteContactById(request.getContactId());
		
		response.setContact(contact);
		response.setDeleted(deletedRecords);
		response.setDescription(AppConstants.DELETE_CONTACT_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_CONTACT_INFORMATION_MSG);
		
		return response;
	}
}
