package com.backend.spring;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.backend.spring.configuration.AppConfig;
import com.backend.spring.model.Product;
import com.backend.spring.model.User;
import com.backend.spring.service.ProductService;

public class ProductTest {
	
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	ProductService service = (ProductService) context.getBean("productService");
	
	@Test
	@Transactional
    public void testSaveProduct() {
	 
	 //get list of all Products
	 List<Product> listBeforeSaving = service.findAllProducts();
	 
	 //get list size before saving product
	 int size=listBeforeSaving.size();
		
     // create Product
     Product product = new Product();
     product.setName("Pdt2");
     product.setDescription("description2");
     product.setQuantity(55);
     product.setStatus("full");
     product.setPrice(62.00f);
     
     // storing the Product
     service.saveProduct(product);
     
     //get list of all saved products
     List<Product> products = service.findAllProducts();
     
     //test size of list, it has to increase by 1 if insertion happens 
     assertEquals(products.size(),size+1);
    }
	
	@Test
	@Transactional
	public void testUpdateProduct(){
		
		//delete all previous products
		 service.deleteAllProducts();
		
		// create Product
	     Product product = new Product();
	     product.setName("Non Updated");
	     product.setDescription("description1");
	     product.setQuantity(55);
	     product.setStatus("Full");
	     product.setPrice(62.00f);
	     
	     // storing the Product
	     service.saveProduct(product);
	     
	     //get list of all saved products before updation
	     List<Product> products = service.findAllProducts();
	     
	     //test Product name set before updation
	     assertEquals("Non Updated",products.get(0).getName());
	     
	     //updation
	     product.setName("Updated");
	     service.updateProduct(product);
	     
	     //get list of all saved products after updation
	     List<Product> products2 = service.findAllProducts();
	     
	     //test Product name set after updation
	     assertEquals("Updated",products2.get(0).getName());	     
	}
	
	@Test
	@Transactional
	public void testFindAllProducts(){
		
		 //delete all previous users
		 service.deleteAllProducts();
				
		 // create Product1
	     Product product1 = new Product();
	     product1.setName("Product1");
	     product1.setDescription("description1");
	     product1.setQuantity(55);
	     product1.setStatus("Full");
	     product1.setPrice(63.00f);
	  
	     // storing the Product1
	     service.saveProduct(product1);
	     
	     // create Product2
	     Product product2 = new Product();
	     product2.setName("Product2");
	     product2.setDescription("description2");
	     product2.setQuantity(55);
	     product2.setStatus("Full");
	     product2.setPrice(63.00f);
	     
	  // storing the Product2
	     service.saveProduct(product2);
	     
	   //get list of all saved products
	     List<Product> products = service.findAllProducts(); 
	     
	   //test size of Retrieved List
	     assertEquals(2,products.size());
	}
	
	@Test
	@Transactional
	public void testDeleteProductById(){
		 
		// create Product1
	     Product product1 = new Product();
	     product1.setName("Saved Product");
	     product1.setDescription("description1");
	     product1.setQuantity(55);
	     product1.setStatus("Full");
	     product1.setPrice(63.00f);
	  
	     // storing the Product1
	     service.saveProduct(product1);
	     
	     // create Product2
	     Product product2 = new Product();
	     product2.setName("Deleted Product");
	     product2.setDescription("description2");
	     product2.setQuantity(55);
	     product2.setStatus("Full");
	     product2.setPrice(63.00f);
	     
	     // storing the Product2
	     service.saveProduct(product2);
	     
	     //testing Product existence before deletion
	     Product pdt=service.findById(product2.getId());
	     assertNotNull(pdt);
	     
	     //deletion by id
	     service.deleteProductById(product2.getId());
	     
	     //testing Product existence after deletion
	     Product pdtNull=service.findById(product2.getId());
	     assertNull(pdtNull);
	}
	
	@Test
	@Transactional
	public void testFindById(){
		// create Product1
	     Product product1 = new Product();
	     product1.setName("Product1");
	     product1.setDescription("description1");
	     product1.setQuantity(55);
	     product1.setStatus("Full");
	     product1.setPrice(63.00f);
	  
	     // storing the Product1
	     service.saveProduct(product1);
	     
	     // create Product2
	     Product product2 = new Product();
	     product2.setName("Product2");
	     product2.setDescription("description2");
	     product2.setQuantity(55);
	     product2.setStatus("Full");
	     product2.setPrice(63.00f);
	     
	     // storing the Product2
	     service.saveProduct(product2);
	     
	     // create Product3
	     Product product3 = new Product();
	     product3.setName("Product3");
	     product3.setDescription("description3");
	     product3.setQuantity(55);
	     product3.setStatus("Full");
	     product3.setPrice(63.00f);
	  
	     // storing the Product3
	     service.saveProduct(product3);
	     
	     // create the Product4
	     Product product4 = new Product();
	     product4.setName("Product4");
	     product4.setDescription("description4");
	     product4.setQuantity(55);
	     product4.setStatus("Full");
	     product4.setPrice(63.00f);
	     
	     // storing the Product4
	     service.saveProduct(product4);
	     
	     //find by Id
	     Product pdt=service.findById(product3.getId());
	     
	     //test if required product found
	     assertEquals("description3",pdt.getDescription());
	}
	
	@Test
	@Transactional
    public void testDeleteAllProducts() {
		int count=0;
		
		List<Product> listBeforeupdation=service.findAllProducts();
		count = count + listBeforeupdation.size();
		
		 // create the objects needed for testing
	     Product product1 = new Product();
	     product1.setName("Product1");
	     product1.setDescription("description1");
	     product1.setQuantity(55);
	     product1.setStatus("Full");
	     product1.setPrice(63.00f);
	  
	     // storing the objects for the test in the database
	     service.saveProduct(product1);
	     
	     // create the objects needed for testing
	     Product product2 = new Product();
	     product2.setName("Product2");
	     product2.setDescription("description2");
	     product2.setQuantity(55);
	     product2.setStatus("Full");
	     product2.setPrice(63.00f);
	     
	     // storing the objects for the test in the database
	     service.saveProduct(product2);
	     
	     // create the objects needed for testing
	     Product product3 = new Product();
	     product3.setName("Product3");
	     product3.setDescription("description3");
	     product3.setQuantity(55);
	     product3.setStatus("Full");
	     product3.setPrice(63.00f);
	  
	     // storing the objects for the test in the database
	     service.saveProduct(product3);
	     
	     // create the objects needed for testing
	     Product product4 = new Product();
	     product4.setName("Product4");
	     product4.setDescription("description4");
	     product4.setQuantity(55);
	     product4.setStatus("Full");
	     product4.setPrice(63.00f);
	     
	     // storing the objects for the test in the database
	     service.saveProduct(product4);
	 
	     //get list of all previously saved products before deletion
         List<Product> productsBefore = service.findAllProducts();
         
         //test list size before deletion
         assertEquals(count+4,productsBefore.size());
     
         //delete all Products
    	 service.deleteAllProducts();
    	 
    	//get list of all previously saved products after deletion
         List<Product> productsAfter = service.findAllProducts();
         
         //test if list is empty
         assertEquals(0,productsAfter.size());
    }
}
