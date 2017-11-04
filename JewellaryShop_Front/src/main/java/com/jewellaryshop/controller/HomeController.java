package com.jewellaryshop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.backend.spring.configuration.AppConfig;
import com.backend.spring.model.Cart;
import com.backend.spring.model.Orders;
import com.backend.spring.model.Product;
import com.backend.spring.model.User;
import com.backend.spring.service.CartService;
import com.backend.spring.service.OrdersService;
import com.backend.spring.service.ProductService;
import com.backend.spring.service.UserService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Controller
public class HomeController
{
	
	public User initFlow(){
		return new User();
	}
           
	public HomeController(){
		System.out.println("HomeController()");   	
	}
	
    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView listProduct(ModelAndView model) throws IOException
	{ 
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ProductService service = (ProductService) context.getBean("productService");
	    List<Product> li= service.findAllProducts();
		Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        String jsonProducts=gson.toJson(li);
        model.addObject("lists",jsonProducts);
        model.setViewName("adminPage");
        return model;
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;

	}
	
	@RequestMapping("/aboutus")
    public String about()
	{
        return "aboutus";
    }
	
	@RequestMapping("/contactus")
    public String contact()
	{
        return "contactus";
    }
	
	@RequestMapping("/products")
    public ModelAndView viewAllProducts(ModelAndView model,HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ProductService service = (ProductService) context.getBean("productService");
	    List<Product> li= service.findAllProducts();
		Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        String jsonProducts=gson.toJson(li);
        model.addObject("lists",jsonProducts);
        model.setViewName("allProducts");
        return model;
    }
	
//	 @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
//	    public String accessDeniedPage() {
//	       return "accessDenied";
//	    }

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
	      
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("loginPage");

		return model;
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

	  ModelAndView model = new ModelAndView();

	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addObject("username", userDetail.getUsername());
	  }

	  model.setViewName("403");
	  return model;

	}
	
	@RequestMapping(value="/defaultlogin",method = RequestMethod.GET)
	public ModelAndView dafaultLogin(HttpServletRequest request){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ProductService service = (ProductService) context.getBean("productService");
		UserService uservice = (UserService) context.getBean("userService");
		CartService cartservice = (CartService) context.getBean("cartService");
		OrdersService orderservice = (OrdersService) context.getBean("ordersService");
		Set<Orders> orders;
		Set<Product> pdt;
		
		if(request.getParameter("id") != null){
			System.out.println("Id taken");
			int productId = Integer.parseInt(request.getParameter("id"));
	        Product product = service.findById(productId);
	        
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name=auth.getName();
			String pw=auth.getCredentials().toString();
			int uid=uservice.findByNamePassword(name, pw).getId();
			User user=uservice.findById(uid);
			Cart cart;
			if(user.getCart()==null){
				System.out.println("Login not so everying absent");
				orders=new HashSet<Orders>();
				pdt=new HashSet<Product>();
				pdt.add(product);
				cart=new Cart();
				cart.setUser(user);
				cartservice.saveCart(cart);
				Orders o=new Orders();
				o.setCart(cart);
				o.setProductset(pdt);
				orders.add(o);
				cart.setOrderset(orders);
				cartservice.updateCart(cart);
				orderservice.saveOrders(o);
				Set<Product> li= orders.iterator().next().getProductset();
				Gson gson = new GsonBuilder()
		                .disableHtmlEscaping()
		                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
		                .setPrettyPrinting()
		                .serializeNulls()
		                .create();
		        String jsonProducts=gson.toJson(li);
		        ModelAndView model=new ModelAndView();
		        model.addObject("lists", jsonProducts);
		        model.setViewName("defaultLogin");
		        return model;
			}
			else{
				System.out.println("Login so everything Present");
				cart=user.getCart();
				orders=cart.getOrderset();
				pdt=orders.iterator().next().getProductset();
				pdt.add(product);
				Orders o=orders.iterator().next();
				o.setProductset(pdt);
				orderservice.updateOrders(o);
				Set<Product> li= orders.iterator().next().getProductset();
				Gson gson = new GsonBuilder()
		                .disableHtmlEscaping()
		                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
		                .setPrettyPrinting()
		                .serializeNulls()
		                .create();
		        String jsonProducts=gson.toJson(li);
		        ModelAndView model=new ModelAndView();
		        model.addObject("lists", jsonProducts);
		        model.setViewName("defaultLogin");
		        return model;
			}
		}
		else{
			
		System.out.println("Id not taken");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name=auth.getName();
		String pw=auth.getCredentials().toString();
		int uid=uservice.findByNamePassword(name, pw).getId();
		User user=uservice.findById(uid);
		String role=user.getRole();
		if(role.equalsIgnoreCase("ROLE_USER")){
			System.out.println("I am User");
			Cart cart;
			if(user.getCart()!=null){
				System.out.println("Cart Present");
				cart=user.getCart();
				orders=cart.getOrderset();
				System.out.println("Order present");
				Set<Product> li= orders.iterator().next().getProductset();
				Gson gson = new GsonBuilder()
			                .disableHtmlEscaping()
			                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
			                .setPrettyPrinting()
			                .serializeNulls()
			                .create();
			        String jsonProducts=gson.toJson(li);
			        ModelAndView model=new ModelAndView();
			        model.addObject("lists", jsonProducts);
			        model.setViewName("defaultLogin");
			        return model;
			}
			else{
				System.out.println("Nothing present");
				orders=new HashSet<Orders>();
				pdt=new HashSet<Product>();
				cart=new Cart();
				cart.setUser(user);
				cartservice.saveCart(cart);
				Orders o=new Orders();
				o.setCart(cart);
				o.setProductset(pdt);
				o.setStatus("Shipped");
				o.setQuantity(1);
				orders.add(o);
				cart.setOrderset(orders);
				cartservice.updateCart(cart);
				orderservice.saveOrders(o);
				Set<Product> li= user.getCart().getOrderset().iterator().next().getProductset();
				Gson gson = new GsonBuilder()
		                .disableHtmlEscaping()
		                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
		                .setPrettyPrinting()
		                .serializeNulls()
		                .create();
		        String jsonProducts=gson.toJson(li);
		        ModelAndView model=new ModelAndView();
		        model.addObject("lists", jsonProducts);
		        model.setViewName("defaultLogin");
		        return model;
			}
		}
		else{
		System.out.println("I am Admin");
	    List<Product> li= service.findAllProducts();
		Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        String jsonProducts=gson.toJson(li);
		ModelAndView model=new ModelAndView();
		model.addObject("lists",jsonProducts);
		model.setViewName("defaultLogin");
		return model;
		}
		}
	}
}
	
	/*@RequestMapping(value="/defaultlogin",method = RequestMethod.GET)
	public ModelAndView dafaultLogin(HttpServletRequest request){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ProductService service = (ProductService) context.getBean("productService");
		UserService uservice = (UserService) context.getBean("userService");
		CartService cartservice = (CartService) context.getBean("cartService");
		OrdersService orderservice = (OrdersService) context.getBean("ordersService");
		Set<Orders> orders;
		Set<Product> pdt;
		
		if(request.getParameter("id") != null){
			System.out.println("Id taken");
			int productId = Integer.parseInt(request.getParameter("id"));
	        Product product = service.findById(productId);
	        
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name=auth.getName();
			String pw=auth.getCredentials().toString();
			int uid=uservice.findByNamePassword(name, pw).getId();
			User user=uservice.findById(uid);
			Cart cart;
			if(user.getCart()==null){
				System.out.println("Login not so everying absent");
				orders=new HashSet<Orders>();
				pdt=new HashSet<Product>();
				cart=new Cart();
				cart.setUser(user);
				Orders o=new Orders();
				o.setCart(cart);
				o.setProductset(pdt);
				orders.add(o);
				cart.setOrderset(orders);
				orderservice.saveOrders(o);
				cartservice.saveCart(cart);
				Set<Product> li= orders.iterator().next().getProductset();
				Gson gson = new GsonBuilder()
		                .disableHtmlEscaping()
		                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
		                .setPrettyPrinting()
		                .serializeNulls()
		                .create();
		        String jsonProducts=gson.toJson(li);
		        ModelAndView model=new ModelAndView();
		        model.addObject("lists", jsonProducts);
		        model.addObject("o_id",o.getId());
		        model.setViewName("defaultLogin");
		        return model;
			}
			else{
				System.out.println("Login so everything Present");
				cart=user.getCart();
				orders=cart.getOrderset();
				pdt=orders.iterator().next().getProductset();
				pdt.add(product);
				Orders o=orders.iterator().next();
				o.setProductset(pdt);
				orderservice.updateOrders(o);
				Set<Product> li= orders.iterator().next().getProductset();
				Gson gson = new GsonBuilder()
		                .disableHtmlEscaping()
		                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
		                .setPrettyPrinting()
		                .serializeNulls()
		                .create();
		        String jsonProducts=gson.toJson(li);
		        ModelAndView model=new ModelAndView();
		        model.addObject("lists", jsonProducts);
		        model.addObject("o_id",o.getId());
		        model.setViewName("defaultLogin");
		        return model;
			}
		}
		else{
			
		System.out.println("Id not taken");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name=auth.getName();
		String pw=auth.getCredentials().toString();
		int uid=uservice.findByNamePassword(name, pw).getId();
		User user=uservice.findById(uid);
		String role=user.getRole();
		if(role.equalsIgnoreCase("ROLE_USER")){
			System.out.println("I am User");
			Cart cart;
			if(user.getCart()!=null){
				System.out.println("Cart Present");
				cart=user.getCart();
				orders=cart.getOrderset();
				System.out.println("Order present");
				Set<Product> li= orders.iterator().next().getProductset();
				Gson gson = new GsonBuilder()
			                .disableHtmlEscaping()
			                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
			                .setPrettyPrinting()
			                .serializeNulls()
			                .create();
			        String jsonProducts=gson.toJson(li);
			        ModelAndView model=new ModelAndView();
			        model.addObject("lists", jsonProducts);
			        model.setViewName("defaultLogin");
			        return model;
			}
			else{
				System.out.println("Nothing present");
				orders=new HashSet<Orders>();
				pdt=new HashSet<Product>();
				cart=new Cart();
				cart.setUser(user);
				Orders o=new Orders();
				o.setCart(cart);
				o.setProductset(pdt);
				orders.add(o);
				cart.setOrderset(orders);
				orderservice.saveOrders(o);
				cartservice.saveCart(cart);
				Set<Product> li= user.getCart().getOrderset().iterator().next().getProductset();
				Gson gson = new GsonBuilder()
		                .disableHtmlEscaping()
		                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
		                .setPrettyPrinting()
		                .serializeNulls()
		                .create();
		        String jsonProducts=gson.toJson(li);
		        ModelAndView model=new ModelAndView();
		        model.addObject("lists", jsonProducts);
		        model.setViewName("defaultLogin");
		        return model;
			}
		}
		else{
		System.out.println("I am Admin");
	    List<Product> li= service.findAllProducts();
		Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        String jsonProducts=gson.toJson(li);
		ModelAndView model=new ModelAndView();
		model.addObject("lists",jsonProducts);
		model.setViewName("defaultLogin");
		return model;
		}
		}
	}*/

