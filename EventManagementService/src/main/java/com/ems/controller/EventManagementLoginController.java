package com.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class EventManagementLoginController {
	//@RequestMapping("/welcome")
	@GetMapping("/welcome")
	@ResponseBody
	public String login() {
		return "Logged In";
	}
}
