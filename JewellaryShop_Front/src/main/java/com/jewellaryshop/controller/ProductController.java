package com.jewellaryshop.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.backend.spring.configuration.AppConfig;
import com.backend.spring.model.Product;
import com.backend.spring.service.ProductService;

@Controller
public class ProductController {

	public ProductController() {
		System.out.println("ProductController()");
	}
    
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
	private ProductService service =  (ProductService) context.getBean("productService");
	
	@RequestMapping(value = "/admin/newProduct", method = RequestMethod.GET)
    public ModelAndView newProduct(ModelAndView model) {
        Product product = new Product();
        model.addObject("product", product);
        model.setViewName("productForm");
        return model;
    }
	
	@RequestMapping(value = "/admin/saveProduct", method = RequestMethod.POST)
    public ModelAndView saveProduct(@ModelAttribute Product product) {
        if (product.getId() == 0) { 
        	if(!product.getFile().isEmpty()){
        		try{
        		byte[] bytes = product.getFile().getBytes();
        		// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists()){
					dir.mkdirs();}
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()+ File.separator + product.getFile().getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				product.setImagepath(serverFile.getAbsolutePath());
				System.out.println("File uploaded to"+product.getImagepath()); 
        		}catch(Exception e){
        		System.out.println("You failed to upload " + e.getMessage()); 
        		}
        	}
        	else{
        		System.out.println("File is empty");
        	}
            service.saveProduct(product);
        } else {
        	if(!product.getFile().isEmpty()){
        		try{
        		byte[] bytes = product.getFile().getBytes();
        		// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists()){
					dir.mkdirs();}
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()+ File.separator + product.getFile().getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				product.setImagepath(serverFile.getAbsolutePath());
				System.out.println("File uploaded to"+product.getImagepath()); 
        		}catch(Exception e){
        		System.out.println("You failed to upload " + e.getMessage()); 
        		}
        	}
        	else{
        		System.out.println("File is empty");
        	}
            service.updateProduct(product);
        }
        return new ModelAndView("redirect:/admin");
    }
	
	@RequestMapping(value = "/admin/deleteProduct", method = RequestMethod.GET)
    public ModelAndView deleteProduct(HttpServletRequest request) {
        int productId = Integer.parseInt(request.getParameter("id"));
        service.deleteProductById(productId);
        return new ModelAndView("redirect:/admin");
    }
 
	@RequestMapping(value = "/admin/editProduct", method = RequestMethod.GET)
    public ModelAndView editProduct(HttpServletRequest request) {
        int productId = Integer.parseInt(request.getParameter("id"));
        Product product = service.findById(productId);
        ModelAndView model = new ModelAndView("productForm");
        model.addObject("product", product);
        return model;
    }
}
