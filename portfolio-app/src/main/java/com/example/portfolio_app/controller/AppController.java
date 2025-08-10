package com.example.portfolio_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	@GetMapping("/about")
	public String aboutMe()
	{
		return "about";
	}
	
	@GetMapping("/education")
	public String educationPage() {
	    return "education";  
	}
	@GetMapping("/skills")
	public String skillsPage() {
	    return "skills";  
	}
	@GetMapping("/contact")
	public String contactPage()
	{
		return "contact";
	}
}
