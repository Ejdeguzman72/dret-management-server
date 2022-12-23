package com.deguzman.domain;

import java.util.List;

public class ExpenseListResponse {

	public List<Expense> list;
	public int count;
	public String message;
	public String statusCode;
	public String description;
	
	public List<Expense> getList() {
		return list;
	}
	public void setList(List<Expense> list) {
		this.list = list;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
