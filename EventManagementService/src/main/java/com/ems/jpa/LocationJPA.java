package com.ems.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ems.entities.*;

public interface LocationJPA extends JpaRepository<Location, Integer>{
	
	@Transactional
	public boolean deleteByCity(String city);
	public List<Location> findByCountry(String country);
	public List<Location> findByCountryAndCity(String country, String city);
	public List<Location> findByCountryOrCity(String country, String city);
	public List<Location> findByCountryAndCityAllIgnoreCase(String country, String city);
	
	
	//The below query is pushed manually not by the JPA.
	@Query(name="bycity")
	public List<Location> findByCities(String cities);
	
	@Query(value="update location set city=:cityName where location_id=:locationId",nativeQuery=true)
	@Modifying
	@Transactional
	public void getByCityName(@Param("locationId") int locationId, @Param("cityName") String city);
}
