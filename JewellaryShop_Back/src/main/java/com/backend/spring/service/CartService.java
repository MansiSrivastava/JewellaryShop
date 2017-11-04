package com.backend.spring.service;

import java.util.List;

import com.backend.spring.model.Cart;

public interface CartService {

void saveCart(Cart cart);
    
    List<Cart> findAllCarts();
     
    void deleteCartById(int id);
     
    Cart findById(int id);
     
    void updateCart(Cart cart);
    
    void deleteAllCarts();
    
}
