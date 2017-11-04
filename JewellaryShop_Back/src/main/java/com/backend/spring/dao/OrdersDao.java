package com.backend.spring.dao;

import java.util.List;

import com.backend.spring.model.Orders;

public interface OrdersDao {

void saveOrders(Orders order);
    
    List<Orders> findAllOrders();
     
    void deleteOrdersById(int id);
     
    Orders findById(int id);
     
    void updateOrders(Orders order);
    
    void deleteAllOrders();
    
}
