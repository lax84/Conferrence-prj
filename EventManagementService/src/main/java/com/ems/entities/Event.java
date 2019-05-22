package com.ems.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.time.format.*;

@Entity
// @Table(name="TechM_Event")
public class Event {

	@Id
	private int eventId;
	/*
	 * @Column(name="event_name", unique=true) //This Unique will define the column
	 * name as Unique. Need not to be done manually on SQL query
	 */ private String name;
	private LocalDate date;
	private String time;
	private float price;
	private String imgUrl;
	
	
	
	

	/*
	 * @Transient private String Lakshman; //This is used to manipulate withing the
	 * Java class and this will not be reflected in the SQL table.
	 */
	@OneToOne
	@JoinColumn(name = "location_id")
	private Location location;

	@OneToMany(targetEntity = Session.class, mappedBy = "event") // Due to bi-directional entity, we need to set the
																	// Target Entity
	private List<Session> sessions = new ArrayList<>();

	public Event() {
		// TODO Auto-generated constructor stub
	}
	
	public Event(int id, String name, LocalDate date, String time, float price, String imgUrl) {
		super();
		this.eventId = id;
		this.name = name;
		this.date = date;
		this.time = time;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", name=" + name + ", date=" + date + ", time=" + time + ", price=" + price
				+ ", imgUrl=" + imgUrl + "]";
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
