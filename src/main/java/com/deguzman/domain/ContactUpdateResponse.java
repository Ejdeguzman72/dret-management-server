package com.deguzman.domain;

public class ContactUpdateResponse {

	public Contact contact;
	public Integer updatedRecords;
	public String message;
	public String statusCode;
	public String description;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Integer getUpdatedReocrds() {
		return updatedRecords;
	}

	public void setUpdatedReocrds(Integer updatedRecords) {
		this.updatedRecords = updatedRecords;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
