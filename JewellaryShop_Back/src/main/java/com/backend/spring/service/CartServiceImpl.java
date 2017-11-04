package com.backend.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.spring.dao.CartDao;
import com.backend.spring.model.Cart;

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService{

	@Autowired
	CartDao dao;
	
	public void saveCart(Cart cart) {
		// TODO Auto-generated method stub
		dao.saveCart(cart);
	}

	public List<Cart> findAllCarts() {
		// TODO Auto-generated method stub
		return dao.findAllCarts();
	}

	public void deleteCartById(int id) {
		// TODO Auto-generated method stub
		dao.deleteCartById(id);
	}

	public Cart findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub
		dao.updateCart(cart);
	}

	public void deleteAllCarts() {
		// TODO Auto-generated method stub
		dao.deleteAllCarts();
	}

}
