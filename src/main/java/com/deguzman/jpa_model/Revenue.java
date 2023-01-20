package com.deguzman.jpa_model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Table(name = "revenue")
@CrossOrigin
public class Revenue {

	public int revenueId;
	public double amount;
	public LocalDate settlementDate;
	
	public RevenueType revenueTypeId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "revenue_id")
	public int getRevenueId() {
		return revenueId;
	}
	public void setRevenueId(int revenueId) {
		this.revenueId = revenueId;
	}
	
	@Column(name = "amount")
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "revenue_type_id")
	public RevenueType getRevenueTypeId() {
		return revenueTypeId;
	}
	public void setRevenueTypeId(RevenueType revenueTypeId) {
		this.revenueTypeId = revenueTypeId;
	}
	@Column(name = "settlement_date")
	public LocalDate getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}
	
}
