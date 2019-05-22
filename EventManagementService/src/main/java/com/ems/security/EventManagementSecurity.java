package com.ems.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ems.exceptions.AccessExceptions;

//This class is for configuring Security features

@Configuration
public class EventManagementSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	AccessExceptions AccessDeniedHandler;

	// Below Configure is written to override the existing configuration in the
	// WebSecurityConfigurerAdapter
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/root/welcome").permitAll().antMatchers("/root/allevents.json")
				.permitAll().antMatchers("/audience/all").permitAll().antMatchers("/audience/all.json").permitAll()
				.antMatchers("/audience/name/{firstName}").permitAll().antMatchers("/audience/name/{firstName}.json")
				.permitAll().antMatchers("/audience/update/{audId}").permitAll()
				.antMatchers("/root/searchlocation/{countryName}").hasRole("User")
				.antMatchers("/root/eventdetails/{eventId}").hasAnyRole("User", "Admin")
				.antMatchers("/root/updatelocation/{locationId}/{cityName}").hasRole("Admin")
				.antMatchers("/root/deletelocation/{locationId}").hasRole("Admin").antMatchers("/root/insert")
				.hasRole("Admin").anyRequest().authenticated().and().cors().and().csrf().disable().httpBasic().and()
				.exceptionHandling().accessDeniedHandler(AccessDeniedHandler);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder).withUser("Lakshman")
				.password(bCryptPasswordEncoder.encode("Addhu")) // {noop} can be added to bypass the login. This should
																	// be provided in the password here
				.roles("User").and() // This .and() separates the user to be included(created)
				.withUser("Addhu").password(bCryptPasswordEncoder.encode("Laddu")).roles("User").and().withUser("Ram")
				.password(bCryptPasswordEncoder.encode("Adithi")).roles("User", "Admin");
	}
}
