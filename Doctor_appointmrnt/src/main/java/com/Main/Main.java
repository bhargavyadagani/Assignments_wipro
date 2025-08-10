package com.Main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Service.AppointmentService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AppointmentService service= (AppointmentService) context.getBean("appointmentService");
		Scanner sc=new Scanner(System.in);
		
		String s1=service.Book("DOC101", "2025-10-23");
		System.out.println(s1);
		
		String s2=service.Book("DOC101", "2025-12-23");
		System.out.println(s2);
		

	}

}
