package com.ems.mongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ems.mongo.document.Audience;

public interface AudienceRepository extends MongoRepository<Audience, Integer>{
	
	@Query(value="{'firstName':?0}",fields="{'age':0,'city':0,'audienceId':0}")
	public List<Audience> findByFirstName(String firstName);
}
