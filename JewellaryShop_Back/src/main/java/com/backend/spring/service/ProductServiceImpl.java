package com.backend.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.backend.spring.dao.ProductDao;
import com.backend.spring.model.Product;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
    private ProductDao dao;
	
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		dao.saveProduct(product);
	}

	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return dao.findAllProducts();
	}

	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		dao.deleteProductById(id);
	}

	public Product findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		dao.updateProduct(product);
	}

	public void deleteAllProducts() {
		// TODO Auto-generated method stub
		dao.deleteAllProducts();
	}

}
