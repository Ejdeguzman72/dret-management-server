package com.deguzman.domain;

public class ContactType {

	public int contactTypeId;
	public String descr;
	
	public int getContactTypeId() {
		return contactTypeId;
	}
	public void setContactTypeId(int contactTypeId) {
		this.contactTypeId = contactTypeId;
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
		result = prime * result + contactTypeId;
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
		return result;
	}
	
}
