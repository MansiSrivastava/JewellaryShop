package com.jewellaryshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.backend.spring.configuration.AppConfig;
import com.backend.spring.model.User;
import com.backend.spring.service.UserService;

@Controller
public class RegistrationController {

    AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
	private UserService userservice=(UserService) context.getBean("userService");
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("signup");
	    mav.addObject("user", new User());
	    return mav;
	  }
	
	  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("user") @Valid User user,BindingResult result) {
		  if(result.hasErrors()){
			  return new ModelAndView("signup");
		  }
	  user.setRole("ROLE_USER");
	  user.setEnabled((short) 1);
	  userservice.saveUser(user);
	  //return new ModelAndView("cartPage", "name", user.getName());
	  ModelAndView model=new ModelAndView("cartPage");
	  model.addObject("name", user.getName());
	  return model;
	  }
}
