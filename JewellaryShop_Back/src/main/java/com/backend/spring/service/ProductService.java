package com.backend.spring.service;

import java.util.List;

import com.backend.spring.model.Product;
 
public interface ProductService {

	void saveProduct(Product product);
    
    List<Product> findAllProducts();
     
    void deleteProductById(int id);
     
    Product findById(int id);
     
    void updateProduct(Product product);
    
    void deleteAllProducts();
}
