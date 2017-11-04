package com.backend.spring.dao;

import java.util.List;

import com.backend.spring.model.Cart;

public interface CartDao {

	void saveCart(Cart cart);
    
    List<Cart> findAllCarts();
     
    void deleteCartById(int id);
     
    Cart findById(int id);
     
    void updateCart(Cart cart);
    
    void deleteAllCarts();
}
