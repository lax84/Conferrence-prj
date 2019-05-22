package com.ems.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name="bycity",query="select l from Location l where l.city =?1") //JPQL line to set the query globally instead in LocationJPA
public class Location {
public Location() {
	// TODO Auto-generated constructor stub
}
	@Id // Primary Key Equalent
	private int locationId;
	private String address;
	private String city;
	private String country;

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", address=" + address + ", city=" + city + ", country=" + country
				+ "]";
	}

	public Location(int locationId, String address, String city, String country) {
		super();
		this.locationId = locationId;
		this.address = address;
		this.city = city;
		this.country = country;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
