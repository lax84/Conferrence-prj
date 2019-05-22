package com.ems.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Voters {
	
	
	
	@Override
	public String toString() {
		return "Voters [voterId=" + voterId + ", voterName=" + voterName + "]";
	}
	@Id
	private int voterId;
	private String voterName;
	
	@ManyToMany(mappedBy="voters")
	private List<Session> sessions = new ArrayList<>();
	
	public Voters() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Voters(int voterId, String voterName) {
		super();
		this.voterId = voterId;
		this.voterName = voterName;
	}
	public int getVoterId() {
		return voterId;
	}
	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}
	public String getVoterName() {
		return voterName;
	}
	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}
	public List<Session> getSessions() {
		return sessions;
	}
	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	
}
