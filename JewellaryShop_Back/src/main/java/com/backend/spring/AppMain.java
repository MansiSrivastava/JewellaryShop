package com.backend.spring;
 
import java.util.List;

 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.backend.spring.configuration.AppConfig;
import com.backend.spring.model.Product;
import com.backend.spring.service.ProductService;
 
public class AppMain {
	
    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
 
        ProductService service = (ProductService) context.getBean("productService");
 
        /*
         * Create Product1
         */
        Product pdt1 = new Product();
        pdt1.setName("Chesta");
        pdt1.setDescription("Gud1");
        pdt1.setQuantity(12);
        pdt1.setStatus("Full");
        pdt1.setImagepath("ip1");
        pdt1.setPrice(10.0f);
 
        /*
         * Create Product2
         */
        Product pdt2 = new Product();
        pdt2.setName("CCTV");
        pdt2.setDescription("Gudees");
        pdt2.setQuantity(16);
        pdt2.setStatus("Half");
        pdt2.setImagepath("ip1");
        pdt2.setPrice(10.0f);
 
        /*
         * Persist both Products
         */
        service.saveProduct(pdt1);
        service.saveProduct(pdt2);
        
        /*
         * Get all products list from database
         */
        List<Product> products = service.findAllProducts();
        for (Product pdt : products) {
            System.out.println(pdt);
        }
 
        /*
         * delete a Product
         */
        service.deleteProductById(pdt1.getId());
 
        /*
         * update a Product
         */
        Product product = service.findById(pdt2.getId());
        product.setPrice(20);
        service.updateProduct(product);
         
        /*
         * Get all products list from database
         */
        List<Product> productList = service.findAllProducts();
        for (Product pdt : productList) {
            System.out.println(pdt);
        }
 
        context.close();
    }
}