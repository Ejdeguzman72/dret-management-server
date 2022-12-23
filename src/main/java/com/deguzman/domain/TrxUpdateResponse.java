package com.deguzman.domain;

public class TrxUpdateResponse {

	public Transaction transaction;
	public int recordsUpdated;
	public String message;
	public String statusCode;
	public String description;

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public int getRecordsUpdated() {
		return recordsUpdated;
	}

	public void setRecordsUpdated(int recordsUpdated) {
		this.recordsUpdated = recordsUpdated;
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
