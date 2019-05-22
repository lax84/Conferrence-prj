package com.ems.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Session {
	
	
	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId + ", name=" + name + ", presenter=" + presenter + ", duration="
				+ duration + ", level=" + level + ", description=" + description + ", voters=" + voters + "]";
	}

	@Id
	private int sessionId;
	private String name;
	private String presenter;
	private int duration;
	private String level;
	private String description;
	
	@ManyToMany
	@JsonIgnore
	@JoinTable
	(name="Sessions_Voters",
	joinColumns=@JoinColumn(name="session_id"),
	inverseJoinColumns=@JoinColumn(name="voter_id")
	)
	private List<Voters> voters=new ArrayList<>();

	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "event_id")
	private Event event;

	public Session() {

		// TODO Auto-generated constructor stub
	}

	public Session(int id, String name, String presenter, int duration, String level, String description) {
		super();
		this.sessionId = id;
		this.name = name;
		this.presenter = presenter;
		this.duration = duration;
		this.level = level;
		this.description = description;
	}

	public List<Voters> getVoters() {
		return voters;
	}

	public void setVoters(List<Voters> voters) {
		this.voters = voters;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPresenter() {
		return presenter;
	}

	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
