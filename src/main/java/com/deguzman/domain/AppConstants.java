package com.deguzman.domain;

import org.springframework.http.HttpStatus;

public class AppConstants {
	
	public static final HttpStatus HTTP_STATUS_OK = HttpStatus.OK;

	public static String GET_CONTACT_LIST_DESCR = "GET CONTACT LIST";
	
	public static String GET_CONTACT_LIST_MSG = "Retrieving all contacts from database";
	
	public static String SEARCH_CONTACT_BY_TYPE_DESCR = "SEARCH CONTACTS BY CONTACT TYPE";
	
	public static String SEARCH_CONTACT_BY_TYPE_MSG = "Searching contacts based of type";
	
	public static String SEARCH_CONTACT_BY_NAME_DESCR = "SEARCH CONTACT BY NAME";
	
	public static String SEARCH_CONTACT_BY_NAME_MSG = "Searching contact based off name";
	
	public static String ADD_CONTACT_INFORMATION_DESCR = "ADD CONTACT";
	
	public static String ADD_CONTACT_INFORMATION_MSG = "Inserting new contact information";
	
	public static String UPDATE_CONTACT_INFORMATION_DESCR = "UPDATE CONTACT";
	
	public static String UPDATE_CONTACT_INFORMATION_MSG = "Updating contact information";
	
	public static String DELETE_CONTACT_INFORMATION_DESCR = "DELETE CONTACT";
	
	public static String DELETE_CONTACT_INFORMATION_MSG = "Deleteing contact information by contactId";

}
