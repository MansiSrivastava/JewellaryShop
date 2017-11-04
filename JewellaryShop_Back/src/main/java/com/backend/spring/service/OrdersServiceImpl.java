package com.backend.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.spring.dao.OrdersDao;
import com.backend.spring.model.Orders;

@Service("ordersService")
@Transactional
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	OrdersDao dao;
	
	public void saveOrders(Orders order) {
		// TODO Auto-generated method stub
		dao.saveOrders(order);
	}

	public List<Orders> findAllOrders() {
		// TODO Auto-generated method stub
		return dao.findAllOrders();
	}

	public void deleteOrdersById(int id) {
		// TODO Auto-generated method stub
		dao.deleteOrdersById(id);
	}

	public Orders findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	public void updateOrders(Orders order) {
		// TODO Auto-generated method stub
		dao.updateOrders(order);
	}

	public void deleteAllOrders() {
		// TODO Auto-generated method stub
		dao.deleteAllOrders();
	}

}
