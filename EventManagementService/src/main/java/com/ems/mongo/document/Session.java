package com.ems.mongo.document;

public class Session {
	private int sessionid;
	private String sessionname;
	private String level;

	public Session(int sessionid, String sessionname, String level) {
		super();
		this.sessionid = sessionid;
		this.sessionname = sessionname;
		this.level = level;
	}

	public Session() {
		// TODO Auto-generated constructor stub
	}

	public int getSessionid() {
		return sessionid;
	}

	public void setSessionid(int sessionid) {
		this.sessionid = sessionid;
	}

	public String getSessionname() {
		return sessionname;
	}

	public void setSessionname(String sessionname) {
		this.sessionname = sessionname;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
