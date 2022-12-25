package com.deguzman.jpa_model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "contact_type")
@CrossOrigin
public class ContactType {

	public int contactTypeId;
	public String descr;
	
	public List<Contact> contact;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "contact_type_id")
	public int getContactTypeId() {
		return contactTypeId;
	}
	public void setContactTypeId(int contactTypeId) {
		this.contactTypeId = contactTypeId;
	}
	
	@Column(name = "descr")
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy="contactType")
	@JsonIgnore
	public List<Contact> getContact() {
		return contact;
	}
	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + contactTypeId;
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
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
		ContactType other = (ContactType) obj;
		if (contactTypeId != other.contactTypeId)
			return false;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ContactType [contactTypeId=" + contactTypeId + ", descr=" + descr + "]";
	}
	public ContactType(int contactTypeId, String descr) {
		super();
		this.contactTypeId = contactTypeId;
		this.descr = descr;
	}
	public ContactType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
