package com.deguzman.jpa_model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "transaction_type")
@CrossOrigin
public class TransactionType {

	public int transactionTypeId;
	public String descr;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "transaction_type_id")
	public int getTransactionTypeId() {
		return transactionTypeId;
	}
	public void setTransactionTypeId(int transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
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
		TransactionType other = (TransactionType) obj;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		if (transactionTypeId != other.transactionTypeId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionType [transactionTypeId=" + transactionTypeId + ", descr=" + descr + "]";
	}
	public TransactionType(int transactionTypeId, String descr) {
		super();
		this.transactionTypeId = transactionTypeId;
		this.descr = descr;
	}
	public TransactionType() {
		super();
		// TODO Auto-generated constructor stub
	}
}
