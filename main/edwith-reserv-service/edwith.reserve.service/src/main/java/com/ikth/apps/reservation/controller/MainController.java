package com.ikth.apps.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController 
{
	@GetMapping(path="/")
	public String main() {
		return "main";
	}
	
	@GetMapping(path="/error")
	public String error(ModelMap model, @RequestParam("cause") String cause) {
		model.addAttribute("cause", cause);
		return "error";
	}
}