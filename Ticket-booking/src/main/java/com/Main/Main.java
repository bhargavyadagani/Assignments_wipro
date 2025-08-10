package com.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.booking.FlightService;
import com.booking.TicketService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext();
		
		FlightService fc= (FlightService) context.getBean("flight");
		
		TicketService tc=(TicketService) context.getBean("ticket");
		
		String result1 = tc.conformBooking("FL123", "User1");
        String result2 = tc.conformBooking("FL345", "User2");
        
        System.out.println(result1);
        System.out.println(result2);
		
	}

}
