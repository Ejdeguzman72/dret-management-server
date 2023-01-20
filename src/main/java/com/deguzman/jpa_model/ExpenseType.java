package com.deguzman.jpa_model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "expense_type")
@CrossOrigin
public class ExpenseType {

	private int expenseTypeId;
	private String descr;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "expense_type_id")
	public int getExpenseTypeId() {
		return expenseTypeId;
	}
	public void setExpenseTypeId(int expenseTypeId) {
		this.expenseTypeId = expenseTypeId;
	}
	
	@Column(name = "descr")
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
		result = prime * result + expenseTypeId;
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
		ExpenseType other = (ExpenseType) obj;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		if (expenseTypeId != other.expenseTypeId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ExpenseType [expenseTypeId=" + expenseTypeId + ", descr=" + descr + "]";
	}
	public ExpenseType(int expenseTypeId, String descr) {
		super();
		this.expenseTypeId = expenseTypeId;
		this.descr = descr;
	}
	public ExpenseType() {
		super();
		// TODO Auto-generated constructor stub
	}
}
