package com.backend.spring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.backend.spring.configuration.AppConfig;
import com.backend.spring.model.Cart;
import com.backend.spring.model.Orders;
import com.backend.spring.model.Product;
import com.backend.spring.model.User;
import com.backend.spring.service.OrdersService;
import com.backend.spring.service.ProductService;

public class AppMainOrders {

	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		OrdersService service=(OrdersService)context.getBean("ordersService");
		
		Set<Product> pdt=new HashSet<Product>();
		User user=new User();
		user.setName("MansiSrivas");
		user.setPassword("pw");
		user.setPhoneno("9654081469");
		user.setState("UP");
		user.setCity("Gzb");
		user.setCountry("India");
		user.setEmail("email@mm.com");
		user.setHouseno("257");
		
		Cart cart=new Cart(user);
		
		Product product1=new Product();
		product1.setName("AAAA");
		product1.setPrice(12);
		product1.setDescription("Gut");
		product1.setQuantity(5);
		product1.setStatus("shipped");
		product1.setImagepath("nbsc/bx/nvcsz");
		
		pdt.add(product1);
			
		Orders order=new Orders();
		order.setQuantity(2);
		order.setStatus("Shipping");
		order.setCart(cart);
		order.setProductset(pdt);
		
		service.saveOrders(order);
	}

}
