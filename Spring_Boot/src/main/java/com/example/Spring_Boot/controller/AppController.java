package com.example.Spring_Boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
	    @GetMapping("/")
	    public String showHomePage() {
	        return "home"; // This will map to /WEB-INF/home.jsp
	    }
	    @GetMapping("/test")
	    public String testPage() {
	        return "test"; // Resolves to /WEB-INF/test.jsp
	    }
	    @PostMapping("login")
	    
	    	public String Login(@RequestParam String uname, @RequestParam String psw)
	    	{
	    		if(uname.equalsIgnoreCase("Bhargav")&& psw.equalsIgnoreCase("bhargav7878")) {
	    			return "dashbord";
	    		}
	    		else
	    		{
	    			System.out.println(" user credentials is not correct");
	            	
	        		return "home";
	    		}
	    	}
	    }
	 
	

