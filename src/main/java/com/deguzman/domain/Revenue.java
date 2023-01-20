package com.deguzman.domain;

import java.time.LocalDate;

public class Revenue {

	public int revenueId;
	public double amount;
	public int revenueTypeId;
	public LocalDate settlementDate;
	
	public int getRevenueId() {
		return revenueId;
	}
	public void setRevenueId(int revenueId) {
		this.revenueId = revenueId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getRevenueTypeId() {
		return revenueTypeId;
	}
	public void setRevenueTypeId(int revenueTypeId) {
		this.revenueTypeId = revenueTypeId;
	}
	public LocalDate getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}
}
