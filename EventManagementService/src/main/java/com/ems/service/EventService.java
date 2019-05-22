package com.ems.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ems.entities.Event;
import com.ems.dao.EventDAO;
import com.ems.entities.Location;
import com.ems.exceptions.*;

@Service
public class EventService {
	@Autowired
	EventDAO eventDAO;
	public List<Event> getAllEventDetails(){
		return eventDAO.getAllEventDetails();
	}
	public boolean updateLocationCity(int locationId, String cityName) {
		return eventDAO.updateLocationCity(locationId, cityName);
	}
	
	public boolean deleteLocation(int locationId) {
		return eventDAO.deleteLocation(locationId);
	}
	
	public List<Location> searchByLocationCountry (String countryName) throws CityNameNotFoundException{
		return eventDAO.searchByLocationCountry(countryName);
	}
	
	public boolean insertLocation(List<Location> locations) {
		return eventDAO.insertLocation(locations);
	}
	
	public Event getEventDetails(int eventId) {
		return eventDAO.getEventDetails(eventId);
	}
	
	public boolean insertEventDetails() {
		return eventDAO.insertEventDetails();
	}
	
}
