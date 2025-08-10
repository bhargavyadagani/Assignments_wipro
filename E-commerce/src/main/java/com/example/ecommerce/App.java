package com.example.ecommerce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.ecommerce.config.AppConfig;
import com.example.ecommerce.service.OrderService;

public class App {

	public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = context.getBean(OrderService.class);

        System.out.println(orderService.checkout("CART001")); 
        System.out.println(orderService.checkout("CART999")); 
    }

}
