package com.ems.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ems.entities.*;
import com.ems.jpa.*;
import com.ems.exceptions.*;

/*import com.ems.model.Event;
import com.ems.model.Location;
import com.ems.pojo.EventLocation;
import com.ems.pojo.Voters;
import com.ems.model.Session;*/

@Repository
public class EventDAO {
	
	
		//@Autowired
		JdbcTemplate jdbcTemplate;
		
		//@Autowired
		SessionFactory sessionFactory; //This is the replacement for the JDBC template
		
		@Autowired
		EventJPA eventJPA;
		
		@Autowired
		LocationJPA locationJPA;
		
		@Autowired
		SessionJPA sessionJPA;
		
		@Autowired
		VotersJPA votersJPA;
		
		@Transactional
		public boolean insertLocation(List<Location> locations) {
			org.hibernate.Session session = sessionFactory.getCurrentSession();
			//locations.forEach(1 -> session.save(1));
			locations.forEach(l -> session.save(l));
			return true;
		}
		
		//@Transactional
		public boolean deleteLocation(int locationId) {
			/*org.hibernate.Session session=sessionFactory.getCurrentSession();
			
			Location location = session.get(Location.class, locationId);
			session.delete(location);*/
			locationJPA.deleteById(locationId);
			return true;
		}
		
		//@Transactional
		public boolean updateLocationCity(int locationId, String cityName) {
			/*org.hibernate.Session session=sessionFactory.getCurrentSession();
			
			Location location = session.get(Location.class, locationId);
			location.setCity(cityName);*/
			
			locationJPA.getByCityName(locationId, cityName);
			return true;
		}
		
		public List<Location> searchByLocationCountry(String countryName) throws CityNameNotFoundException{
			//org.hibernate.Session session=sessionFactory.getCurrentSession();
			/*org.hibernate.Session session=sessionFactory.openSession();
			
			//Location location = session.get(Location.class, 101);
			
			//HQL (Hibernate Query Language) - Java Persistence Query Language (JPQL)
			//HQL deals with the entity.
			//The below deprecated query will have performance problem. So the Java Persistence query should be included.
			//Query<Location> query1 = session.createQuery("from Location loc where loc.country='USA'");
			
			//SQL - Deals with the table
			//javax.persistence.Query query2 = session.createNativeQuery("select *from location");
			javax.persistence.Query query2 = session.createQuery("from Location loc where loc.country=?1");
			
			query2.setParameter(1,countryName);
			List<Location> locations=query2.getResultList();
			*/
			
			//The below line is simplified with the JPA code.
			//List<Location> locations=locationJPA.findByCountry(countryName);
			List<Location> locations=locationJPA.findByCities(countryName);
			if(locations.isEmpty()) {
				throw new CityNameNotFoundException("Hi! The given cannot be found.");
				
			}
			return locations;
		}
		
		//@Transactional
		public boolean insertEventDetails() {
			
			//org.hibernate.Session session=sessionFactory.getCurrentSession();
			
			//Below code is added from the hibernate demos project. App.java file
			Location location1 = new Location(201,"1057 DT","London","England");
	        Location location2 = new Location(202,"The Excalibur","Las Vegas","USA");
	        Location location3 = new Location(203,"The Palatial America Hotel","Salt Lake City","USA");
	        Location location4 = new Location(204,"The UN Angular Center","New York","USA");

	        Voters voter1 = new Voters(1,"bradgreen");
	        Voters voter2 = new Voters(2,"igorminar");
	        Voters voter3 = new Voters(3,"martinfowler");
	        Voters voter4 = new Voters(4,"johnpapa");

	        Event event = new Event(101,"Angular Connect",LocalDate.of(2036,9,26),"10:00 am",599.99f,"assetsimagesangularconnect-shield.png");

	        event.setLocation(location1);
	        
	        List<Voters> votersList=new ArrayList<>();
	        
	        Session session1 = new Session(301,"UsingAngular4Pipes","Peter Bacon Darwin",1,"Intermediate","Learn all about the new pipes in Angular 4, bothhow to write them");
	        session1.setEvent(event);
	        votersList.add(voter1);
	        votersList.add(voter2);
	        votersList.add(voter3);
	        session1.setVoters(votersList);
	        
	        Session session2 = new Session(302,"Getting the most","Jeff Cross",1,"Intermediate","We all know that our dev teams work hard, but with the right management they can be even more productive, without overworking them.");
	        session2.setEvent(event);
	        votersList.clear();
	        votersList.add(voter2);
	        votersList.add(voter3);
	        session2.setVoters(votersList);
	        
	        Session session3 = new Session(303,"Angular4Performance","Rob Wormald",1,"Advanced","Angular 4 Performance is hot. In this session, we'll see how Angular gets such great performance by preloadi");
	        session3.setEvent(event);
	        votersList.clear();
	        session3.setVoters(votersList);
	        
	        Session session4 = new Session(304,"Angular 5","Brad Green",2,"Advanced","Even though Angular 5 is still 6 years away, we all want to know all about it so that we can spend ");
	        session4.setEvent(event);
	        session4.setVoters(votersList);
	        
	        Session session5 = new Session(305,"BasicsofAngular4","John Papa",2,"Beginner","It's time to learn the basics of Angular 4. This talk will give you everything you need to know about Angular 4 to ");
	        session5.setEvent(event);
	        votersList.clear();
	        votersList.add(voter2);
	        votersList.add(voter3);
	        votersList.add(voter4);
	        session5.setVoters(votersList);
	        
	        
	        //Transaction tx = session.beginTransaction();
	        /*
	        Event event= new Event(101,"Angular Event",LocalDate.of(2019,04,30),"10:00am", 600.00f,"d://img/ang.jpg");
	        //Event object is in Transient state
	        
	        session.save(event); //Persistence state
	*/        
	        locationJPA.save(location1);
	        locationJPA.save(location2);
	        locationJPA.save(location3);
	        locationJPA.save(location4);
	        
	        votersJPA.save(voter1);
	        votersJPA.save(voter2);
	        votersJPA.save(voter3);
	        votersJPA.save(voter4);
	        
	        eventJPA.save(event);
	        
	        sessionJPA.save(session1);
	        sessionJPA.save(session2);
	        sessionJPA.save(session3);
	        sessionJPA.save(session4);
	        sessionJPA.save(session5);
			// App.java pasted code end here.
			return true;
		}
		
		public com.ems.entities.Event getEventDetails(int eventId) {
			//The below method called finder ID (Finder Methods)
			Optional<Event> optionalEvent= eventJPA.findById(eventId);
			return optionalEvent.get();
		}
		
		public List<Event> getAllEventDetails(){
			return eventJPA.findAll();
		}
		
		/*public Event getEventDetails(int eventId) {
			EventLocation eventLocation=jdbcTemplate.queryForObject("select \r\n" + 
					"eventalias.event_id , eventalias.date ,eventalias.imageUrl , \r\n" + 
					"\r\n" + 
					"eventalias.location_Id , eventalias.name , eventalias.price , \r\n" + 
					"\r\n" + 
					"eventalias.time , locati onalias.id, locationalias.address ,\r\n" + 
					" \r\n" + 
					"locationalias.city , locationalias.country \r\n" + 
					"from Event eventalias \r\n" + 
					"left outer join Location locationalias on \r\n" + 
					"eventalias.location_Id=locationalias.id\r\n" + 
					"where eventalias.event_id=?;", new Object[] {eventId}, new EventLocationMapper());
			
			return null;
		}*/
	}

