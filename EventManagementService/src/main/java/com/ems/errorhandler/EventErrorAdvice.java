package com.ems.errorhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ems.exceptions.CityNameNotFoundException;

@ControllerAdvice
public class EventErrorAdvice {
	@ExceptionHandler(value=CityNameNotFoundException.class)
	@ResponseBody
	public String handleError(CityNameNotFoundException ex) {
		return ex.getMessage();
	}
}
