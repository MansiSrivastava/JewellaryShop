package com.backend.spring;

import static org.junit.Assert.assertEquals;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.backend.spring.configuration.AppConfig;
import com.backend.spring.model.User;
import com.backend.spring.service.UserService;

public class UserTest {

	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	UserService service = (UserService) context.getBean("userService");
	
	@Test
	@Transactional
    public void testSaveUser() {
	
	int countBefore=0,countAfter=0;
	
	//get list of all users
    List<User> listBeforeSaving = service.findAllUsers();
    
    //get count previously saved users
    countBefore = listBeforeSaving.size();
				
	// create user
	 User user = new User();
     user.setName("Mansi");
     user.setEmail("mans@g.com");
     user.setPassword("sgfn23355");
     user.setHouseno("H-270");
     user.setCity("Gzb");
     user.setState("UP");
     user.setCountry("India");
     user.setPhoneno("9654081469");
     
     // storing the user
     service.saveUser(user);
     
     //get list of all saved users
     List<User> listAfterSaving = service.findAllUsers();
     
     //get count After saving user
     countAfter = listAfterSaving.size();
     
     //test size of list
     assertEquals(countBefore+1 , countAfter);
    }
	
	@Test
	@Transactional
	public void testUpdateUser(){
		
		// create user
		 User user = new User();
	     user.setName("Not Updated");
	     user.setEmail("mans@g.com");
	     user.setPassword("sgfn23355");
	     user.setHouseno("H-270");
	     user.setCity("Gzb");
	     user.setState("UP");
	     user.setCountry("India");
	     user.setPhoneno("9654081469");
	     
	     // storing the user
	     service.saveUser(user);
	     
	     //get list of all saved users before updation
	     List<User> users = service.findAllUsers();
	     
	     //test User name set before updation
	     assertEquals("Not Updated",users.get(users.size()-1).getName());
	     
	     //updation
	     user.setName("Updated");
	     service.updateUser(user);
	     
	     //get list of all saved users after updation
	     List<User> users2 = service.findAllUsers();
	     
	     //test User name set after updation
	     assertEquals("Updated",users2.get(users2.size()-1).getName());	     
	}
	
	@Test
	@Transactional
	public void testFindAllUsers(){
		
		// create User1
		 User user1 = new User();
	     user1.setName("User1");
	     user1.setEmail("mans@g.com");
	     user1.setPassword("sgfn23355");
	     user1.setHouseno("H-270");
	     user1.setCity("Gzb");
	     user1.setState("UP");
	     user1.setCountry("India");
	     user1.setPhoneno("9654081469");
	  
	     // storing the User1
	     service.saveUser(user1);
	     
	     // create User2
	     User user2 = new User();
	     user2.setName("User2");
	     user2.setEmail("mans@g.com");
	     user2.setPassword("sgfn23355");
	     user2.setHouseno("H-270");
	     user2.setCity("Gzb");
	     user2.setState("UP");
	     user2.setCountry("India");
	     user2.setPhoneno("9654081469");
	     
	     // storing the User2
	     service.saveUser(user2);
	     
	     //get list of all saved products
	     List<User> users = service.findAllUsers(); 
	     
	     //test if the retrieved List is not empty
	     assertNotNull(users);
	}
	
	@Test
	@Transactional
	public void testDeleteUserById(){
		 // create User1
		 User user1 = new User();
		 user1.setName(" Saved User");
	     user1.setEmail("mans@g.com");
	     user1.setPassword("sgfn23355");
	     user1.setHouseno("H-270");
	     user1.setCity("Gzb");
	     user1.setState("UP");
	     user1.setCountry("India");
	     user1.setPhoneno("9654081469");
	  
	     // storing the User1
	     service.saveUser(user1);
	     
	     // create User2
	     User user2 = new User();
	     user2.setName("Deleted User");
	     user2.setEmail("mans@g.com");
	     user2.setPassword("sgfn23355");
	     user2.setHouseno("H-270");
	     user2.setCity("Gzb");
	     user2.setState("UP");
	     user2.setCountry("India");
	     user2.setPhoneno("9654081469");
	     
	     // storing the User2
	     service.saveUser(user2);
	     
	     //testing Product existence before deletion
	     User user=service.findById(user2.getId());
	     assertNotNull(user);
	     
	     //deletion by id
	     service.deleteUserById(user2.getId());
	     
	     //testing Product existence after deletion
	     User userNull=service.findById(user2.getId());
	     assertNull(userNull);
	}
	
	@Test
	@Transactional
	public void testFindById(){
		// create User1
		 User user1 = new User();
		 user1.setName("User1");
	     user1.setEmail("mans@g.com");
	     user1.setPassword("sgfn23355");
	     user1.setHouseno("H-270");
	     user1.setCity("Gzb");
	     user1.setState("UP");
	     user1.setCountry("India");
	     user1.setPhoneno("9654081469");
	  
	     // storing the User1
	     service.saveUser(user1);
	     
	     // create User2
	     User user2 = new User();
	     user2.setName("User2");
	     user2.setEmail("mans@g.com");
	     user2.setPassword("sgfn23355");
	     user2.setHouseno("H-270");
	     user2.setCity("Gzb");
	     user2.setState("UP");
	     user2.setCountry("India");
	     user2.setPhoneno("9654081469");
	     
	     // storing the User2
	     service.saveUser(user2);
	     
	  // create User3
	     User user3 = new User();
	     user3.setName("User3");
	     user3.setEmail("mans@g.com");
	     user3.setPassword("sgfn23355");
	     user3.setHouseno("H-270");
	     user3.setCity("Gzb");
	     user3.setState("UP");
	     user3.setCountry("India");
	     user3.setPhoneno("9654081469");
	  
	     // storing the User3
	     service.saveUser(user3);
	     
	     // create User4
	     User user4 = new User();
	     user4.setName("User4");
	     user4.setEmail("fsn@gmail.com");
	     user4.setPassword("sgfn23355");
	     user4.setHouseno("H-270");
	     user4.setCity("Gzb");
	     user4.setState("UP");
	     user4.setCountry("India");
	     user4.setPhoneno("9654081469");
	     
	     // storing the User4
	     service.saveUser(user4);
	     
	     //find by Id
	     User user=service.findById(user3.getId());
	     
	     //test if required product found
	     assertEquals("mans@g.com",user.getEmail());
	}
}
