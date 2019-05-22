package com.ems.mongo.document;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "audience")
public class Audience {
	@Id
	private int audienceId;
	private String firstname;
	private String lastname;
	private String city;
	private int age;
	private String gender;
	private List<Session> sessions;

	public Audience() {
		// TODO Auto-generated constructor stub
	}

	public Audience(int audienceId, String firstname, String lastname, String city, int age, String gender) {
		super();
		this.audienceId = audienceId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
		this.age = age;
		this.gender = gender;
	}

	public int getAudienceId() {
		return audienceId;
	}

	public void setAudienceId(int audienceId) {
		this.audienceId = audienceId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

}
