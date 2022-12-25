package com.deguzman.dto;

import java.time.LocalDate;

public class TransactionDTO {

	private long transactionId;
	private String address01;
	private String address02;
	private String city;
	private String state;
	private String zip;
	private String trxDescr;
	private double amount;
	private LocalDate settlementDate;
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public String getAddress01() {
		return address01;
	}
	public void setAddress01(String address01) {
		this.address01 = address01;
	}
	public String getAddress02() {
		return address02;
	}
	public void setAddress02(String address02) {
		this.address02 = address02;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getTrxDescr() {
		return trxDescr;
	}
	public void setTrxDescr(String trxDescr) {
		this.trxDescr = trxDescr;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}
	
}
