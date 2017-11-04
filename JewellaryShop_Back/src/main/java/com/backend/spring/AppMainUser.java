package com.backend.spring;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.backend.spring.configuration.AppConfig;
import com.backend.spring.model.User;
import com.backend.spring.service.UserService;

public class AppMainUser {

	public static void main(String args[]) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserService service=(UserService)context.getBean("userService");
		
		/*
         * Create User1
         */
        User user1 = new User();
        user1.setName("Mncvns");
        user1.setEmail("m@g.com");
        user1.setPassword("mamamamama");
        user1.setHouseno("H-270");
        user1.setCity("Gzb");
        user1.setState("UP");
        user1.setCountry("India");
        user1.setPhoneno("9654081469");
        
        /*
         * Create User2
         */
        User user2 = new User();
        user2.setName("MansiXX");
        user2.setEmail("m@g.com");
        user2.setPassword("mamamamama");
        user2.setHouseno("H-270");
        user2.setCity("Gzb");
        user2.setState("UP");
        user2.setCountry("India");
        user2.setPhoneno("9654081469");
        
        /*
         * Persist both Users
         */
        service.saveUser(user1);
        service.saveUser(user2);
        
        /*
         * Get all users list from database
         */
        List<User> users = service.findAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        
        /*
         * delete a User
         */
        service.deleteUserById(user1.getId());
 
        /*
         * update a User
         */
        User user = service.findById(user2.getId());
        user.setPhoneno("50000000");
        service.updateUser(user);
        
        /*
         * Get all users list from database
         */
        List<User> userList = service.findAllUsers();
        for (User userlist : userList) {
            System.out.println(userlist);
        }
        
        context.close();
	}
}
