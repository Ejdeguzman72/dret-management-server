package com.deguzman.jpa_model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Entity;

@Entity
@Table(name = "transaction")
public class Transaction {

	private long transactionId;
	private long propertyId;
	private int transactionTypeId;
	private double amount;
	private Date settlementDate;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "transaction_id")
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	
	@Column(name = "property_id")
	public long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}
	
	@Column(name = "transaction_type_id")
	public int getTransactionTypeId() {
		return transactionTypeId;
	}
	public void setTransactionTypeId(int transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}
	
	@Column(name = "amount")
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Column(name = "settlement_date")
	public Date getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (propertyId ^ (propertyId >>> 32));
		result = prime * result + ((settlementDate == null) ? 0 : settlementDate.hashCode());
		result = prime * result + (int) (transactionId ^ (transactionId >>> 32));
		result = prime * result + transactionTypeId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (propertyId != other.propertyId)
			return false;
		if (settlementDate == null) {
			if (other.settlementDate != null)
				return false;
		} else if (!settlementDate.equals(other.settlementDate))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (transactionTypeId != other.transactionTypeId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", propertyId=" + propertyId + ", transactionTypeId="
				+ transactionTypeId + ", amount=" + amount + ", settlementDate=" + settlementDate + "]";
	}
	public Transaction(long transactionId, long propertyId, int transactionTypeId, double amount, Date settlementDate) {
		super();
		this.transactionId = transactionId;
		this.propertyId = propertyId;
		this.transactionTypeId = transactionTypeId;
		this.amount = amount;
		this.settlementDate = settlementDate;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
}
