package com.deguzman.jpa_model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "expense")
@CrossOrigin
public class Expense {

	private long expenseId;
	private double amount;
	private int expenseTypeId;
	private Date incurredDate;
	private Date paymentDate;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "expense_id")
	public long getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(long expenseId) {
		this.expenseId = expenseId;
	}
	
	@Column(name = "amount")
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Column(name = "expense_type_id")
	public int getExpenseTypeId() {
		return expenseTypeId;
	}
	public void setExpenseTypeId(int expenseTypeId) {
		this.expenseTypeId = expenseTypeId;
	}
	
	@Column(name = "incurred_date")
	public Date getIncurredDate() {
		return incurredDate;
	}
	public void setIncurredDate(Date incurredDate) {
		this.incurredDate = incurredDate;
	}
	
	@Column(name = "payment_date")
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (expenseId ^ (expenseId >>> 32));
		result = prime * result + expenseTypeId;
		result = prime * result + ((incurredDate == null) ? 0 : incurredDate.hashCode());
		result = prime * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
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
		Expense other = (Expense) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (expenseId != other.expenseId)
			return false;
		if (expenseTypeId != other.expenseTypeId)
			return false;
		if (incurredDate == null) {
			if (other.incurredDate != null)
				return false;
		} else if (!incurredDate.equals(other.incurredDate))
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", amount=" + amount + ", expenseTypeId=" + expenseTypeId
				+ ", incurredDate=" + incurredDate + ", paymentDate=" + paymentDate + "]";
	}
	public Expense(long expenseId, double amount, int expenseTypeId, Date incurredDate, Date paymentDate) {
		super();
		this.expenseId = expenseId;
		this.amount = amount;
		this.expenseTypeId = expenseTypeId;
		this.incurredDate = incurredDate;
		this.paymentDate = paymentDate;
	}
	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}
}
