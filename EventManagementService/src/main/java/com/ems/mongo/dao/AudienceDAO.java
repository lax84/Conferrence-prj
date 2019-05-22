package com.ems.mongo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.ems.mongo.document.Audience;
import com.ems.mongo.document.Session;
import com.ems.mongo.repositories.AudienceRepository;

@Repository
public class AudienceDAO {
	
	@Autowired
	AudienceRepository audienceRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public List<Audience> getAllAudienceDetails(){
		return audienceRepository.findAll();
	}
	
	public List<Audience> getAudienceDetails(String firstName){
		return audienceRepository.findByFirstName(firstName);
	}
	
	public boolean updateSessionDetails(int audId, Session session) {
		Query query = new Query(Criteria.where("_id"));
		Update update = new Update();
		update.push("sessions", session);
		mongoTemplate.updateFirst(query, update, Audience.class);
		return true;
	}
}
