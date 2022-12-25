package com.deguzman.jpa_model;

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
@Table(name = "contact")
@CrossOrigin
public class Contact {

	private long contactId;
	private int contactTypeId;
	private String firstname;
	private String middleInitial;
	private String lastname;
	private String email;
	private String phone;
	
	private ContactType contactType;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "contact_id")
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	
	
	@Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Column(name = "middle_initial")
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	
	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_type_id")
	public ContactType getContactType() {
		return contactType;
	}
	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (contactId ^ (contactId >>> 32));
		result = prime * result + ((contactType == null) ? 0 : contactType.hashCode());
		result = prime * result + contactTypeId;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((middleInitial == null) ? 0 : middleInitial.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		Contact other = (Contact) obj;
		if (contactId != other.contactId)
			return false;
		if (contactType == null) {
			if (other.contactType != null)
				return false;
		} else if (!contactType.equals(other.contactType))
			return false;
		if (contactTypeId != other.contactTypeId)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (middleInitial == null) {
			if (other.middleInitial != null)
				return false;
		} else if (!middleInitial.equals(other.middleInitial))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactTypeId=" + contactTypeId + ", firstname=" + firstname
				+ ", middleInitial=" + middleInitial + ", lastname=" + lastname + ", email=" + email + ", phone="
				+ phone + ", contactType=" + contactType + "]";
	}
	public Contact(long contactId, int contactTypeId, String firstname, String middleInitial, String lastname,
			String email, String phone, ContactType contactType) {
		super();
		this.contactId = contactId;
		this.contactTypeId = contactTypeId;
		this.firstname = firstname;
		this.middleInitial = middleInitial;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.contactType = contactType;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
