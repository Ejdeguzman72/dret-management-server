package com.deguzman.domain;

import java.util.Date;

public class Expense {

	private long expenseId;
	private double amount;
	private int expenseTypeId;
	private Date incurredDate;
	private Date paymentDate;
	
	public long getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(long expenseId) {
		this.expenseId = expenseId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getExpenseTypeId() {
		return expenseTypeId;
	}
	public void setExpenseTypeId(int expenseTypeId) {
		this.expenseTypeId = expenseTypeId;
	}
	public Date getIncurredDate() {
		return incurredDate;
	}
	public void setIncurredDate(Date incurredDate) {
		this.incurredDate = incurredDate;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
}
