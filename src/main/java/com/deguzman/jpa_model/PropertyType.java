package com.deguzman.jpa_model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "property_type")
@CrossOrigin
public class PropertyType {

	private int propertyTypeId;
	private String descr;
	
	List<Property> property;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "property_type_id")
	public int getPropertyTypeId() {
		return propertyTypeId;
	}
	public void setPropertyTypeId(int propertyTypeId) {
		this.propertyTypeId = propertyTypeId;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy="propertyType")
	@JsonIgnore
	public List<Property> getProperty() {
		return property;
	}
	public void setProperty(List<Property> property) {
		this.property = property;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
		result = prime * result + propertyTypeId;
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
		PropertyType other = (PropertyType) obj;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		if (propertyTypeId != other.propertyTypeId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PropertyType [propertyTypeId=" + propertyTypeId + ", descr=" + descr + "]";
	}
	public PropertyType(int propertyTypeId, String descr) {
		super();
		this.propertyTypeId = propertyTypeId;
		this.descr = descr;
	}
	public PropertyType() {
		super();
		// TODO Auto-generated constructor stub
	}
}
