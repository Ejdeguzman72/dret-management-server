package com.deguzman.repository;

import java.util.List;

import com.deguzman.domain.Contact;

public interface ContactRepository {

	public List<Contact> findAllContacts();
	
	public List<Contact> findContactByType(int contactTypeId);
	
	public List<Contact> findContactByName(String firstname, String lastname);
	
	public int addContactInformation(Contact contact);
	
	public int updateContactInformation(Contact contact, int contactId);
	
	public long deleteContactById(int contactId);
	
}
