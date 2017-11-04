package com.backend.spring.dao;

import java.util.List;

import com.backend.spring.model.Product;
 
public interface ProductDao {
 
    void saveProduct(Product product);
     
    List<Product> findAllProducts();
     
    void deleteProductById(int id);
     
    Product findById(int id);
     
    void updateProduct(Product product);
    
    void deleteAllProducts();
}
