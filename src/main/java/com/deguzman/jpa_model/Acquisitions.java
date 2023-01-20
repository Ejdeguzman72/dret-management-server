package com.deguzman.jpa_model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "acquisitions")
@CrossOrigin
public class Acquisitions {

	private long acquisitionId; 
	private LocalDate acquisitionDate;
	private double amount;
	
	private Property property;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "acquisition_id")
	public long getAcquisitionId() {
		return acquisitionId;
	}
	public void setAcquisitionId(long acquisitionId) {
		this.acquisitionId = acquisitionId;
	}
	
	@Column(name = "acquisition_date")
	public LocalDate getAcquisitionDate() {
		return acquisitionDate;
	}
	public void setAcquisitionDate(LocalDate acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}
	
	@Column(name = "amount")
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "property_id")
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	
	
}
