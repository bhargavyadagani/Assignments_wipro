package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.SpringCore.Address;
import com.SpringCore.Customer;

public class CustomerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Customer c=(Customer) context.getBean("customer");
		System.out.println(c.getName());
		System.out.println(c.getAddr());
		
		Address a=(Address) context.getBean(Address.class);
		System.out.println(a.getCityName());
	}

}
