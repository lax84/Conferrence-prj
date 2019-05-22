package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.mongo.dao.AudienceDAO;
import com.ems.mongo.document.Audience;
import com.ems.mongo.document.Session;

@RestController
@RequestMapping("/audience")
public class EventManagementAudienceController {
	
	@Autowired
	AudienceDAO audienceDAO;
	@GetMapping("/all")
	public List<Audience> getAllAudienceDetails(){
		return audienceDAO.getAllAudienceDetails();
	}
	
	@GetMapping("/name/{firstName}")
	public List<Audience> getAudienceDetails(@PathVariable String firstName){
		return audienceDAO.getAudienceDetails(firstName);
	}
	
	@PostMapping("/update/{audId}")
	public boolean updateSessionDetails(@PathVariable int audId,@RequestBody Session session) {
		return audienceDAO.updateSessionDetails(audId, session);
	}
}
