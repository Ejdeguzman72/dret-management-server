package com.deguzman.jpa_model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Table(name = "revenue_type")
@CrossOrigin
public class RevenueType {

	private int revenueTypeId;
	private String descr;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "revenue_type_id")
	public int getRevenueTypeId() {
		return revenueTypeId;
	}
	public void setRevenueTypeId(int revenueTypeId) {
		this.revenueTypeId = revenueTypeId;
	}
	
	@Column(name = "descr")
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
}
