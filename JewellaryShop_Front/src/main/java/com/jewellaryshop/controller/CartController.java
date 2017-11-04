package com.jewellaryshop.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

@Controller
public class CartController {


	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
	private CartService cartservice=(CartService) context.getBean("cartService");
	private ProductService pdtservice =  (ProductService) context.getBean("productService");
	private UserService userservice = (UserService)context.getBean("userService");
	private OrdersService orderservice = (OrdersService)context.getBean("ordersService");
	
	@RequestMapping(value="/cart/addtocart",method = RequestMethod.GET)
    public ModelAndView addToCart(HttpServletRequest request)
	{	
		int productId = Integer.parseInt(request.getParameter("id"));
        ModelAndView model = new ModelAndView("redirect:/defaultlogin?id="+productId);
        return model;
    }
	
	@RequestMapping(value="/cart/deletefromcart",method = RequestMethod.GET)
    public ModelAndView deleteFromCart(HttpServletRequest request)
	{	
		int productId = Integer.parseInt(request.getParameter("id"));
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name=auth.getName();
		String pw=auth.getCredentials().toString();
		int uid=userservice.findByNamePassword(name, pw).getId();
		User user=userservice.findById(uid);
		Cart cart=user.getCart();
		Set<Product> li=cart.getOrderset().iterator().next().getProductset();
		Iterator<Product> i=li.iterator();
		while(i.hasNext()){
			Product pdt=i.next();
			if(pdt.getId()==productId){
				li.remove(pdt);
				orderservice.updateOrders(cart.getOrderset().iterator().next());
				cartservice.updateCart(cart);
			}
		}
		ModelAndView model = new ModelAndView("redirect:/defaultlogin");
        return model;
    }
	
	@RequestMapping(value="/productdetails",method = RequestMethod.GET)
    public ModelAndView productDetails(HttpServletRequest request)
	{	
		int productId = Integer.parseInt(request.getParameter("id"));
        Product product = pdtservice.findById(productId);
        ModelAndView model = new ModelAndView("productDetails");
        model.addObject("product", product);
        return model;
    }
	
	@RequestMapping(value="/cart/addmorepdts")
	public ModelAndView addMoreProducts(HttpServletRequest request){
		ModelAndView model=new ModelAndView("redirect:/products");
		return model;	
	}
	
	@RequestMapping(value="/shippingAddress",method = RequestMethod.GET)
	public ModelAndView pay(HttpServletRequest request){
		ModelAndView model=new ModelAndView("shippingAddress");
		model.addObject("user", new User());
		return model;
	}
}
