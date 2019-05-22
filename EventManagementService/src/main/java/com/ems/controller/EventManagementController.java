package com.ems.controller;
import com.ems.entities.Location;
import com.ems.exceptions.*;
import com.ems.entities.Event;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.service.EventService;

//@Controller
@RestController
@RequestMapping("/root")
@CrossOrigin

public class EventManagementController {
	InitializingBean ib;
	@Autowired
	EventService eventService;
	//Handler method (End point)
	//@RequestMapping(value="/welcome",method=RequestMethod.GET)
	//The below line and the above line are same.
	
	@GetMapping("/updatelocation/{locationId}/{cityName}")
	@ResponseBody
	public boolean updateLocationCity(@PathVariable int locationId, @PathVariable String cityName) {
		return eventService.updateLocationCity(locationId, cityName);
	}
	
	@DeleteMapping("/deletelocation/{locationId}")
	@ResponseBody
	public boolean deleteLocation(@PathVariable int locationId) {
		return eventService.deleteLocation(locationId);
	}
	
	
	
	@GetMapping("/searchlocation/{countryName}")
	@ResponseBody
	public List<Location> searchByLocationCountry(@PathVariable String countryName) throws CityNameNotFoundException{
		return eventService.searchByLocationCountry(countryName);
	}
	
	@PostMapping("/locations")
	@ResponseBody
	public boolean insertLocation(@RequestBody List<Location> locations) {
		return eventService.insertLocation(locations);
	}
	
	@GetMapping("/allevents")
	public List<Event> getAllEventDetails(){
		return eventService.getAllEventDetails();
	}
	
	@GetMapping("/welcome")
	@ResponseBody
	public String welcome() {
		return "Welcome!";
	}
	
	@GetMapping("/insert")
	@ResponseBody
	public boolean insertEventDetails() {
		return eventService.insertEventDetails();
	}
	//URI Templating feature - URI Template Variable
	@GetMapping("/eventdetails/{eventId}") //The eventID variable and the below getEventDetails parameter variable name should be same.
	@ResponseBody
	public Event getEventDetails(@PathVariable("eventId") int eId) {
		return eventService.getEventDetails(eId);
	}
}
