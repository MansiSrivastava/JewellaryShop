package com.backend.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.support.AbstractApplicationContext;

import com.backend.spring.configuration.AppConfig;
import com.backend.spring.model.Cart;
import com.backend.spring.model.User;
import com.backend.spring.service.CartService;
import com.backend.spring.service.UserService;

public class AppMainCart {

	public static void main(String args[]){
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		CartService service=(CartService)context.getBean("cartService");
		
		UserService uservice=(UserService)context.getBean("userService");
		
		User user=new User();
		user.setName("Swati");
		user.setPassword("pwpwpwpw");
		user.setPhoneno("9654081469");
		user.setState("UP");
		user.setCity("Gzb");
		user.setCountry("India");
		user.setEmail("email@mm.com");
		user.setHouseno("257");
		
		Cart cart=new Cart();
		cart.setUser(user);
		
		service.saveCart(cart);
		
	}
	
}
