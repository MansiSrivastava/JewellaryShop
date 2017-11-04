package com.backend.spring.service;

import java.util.List;

import com.backend.spring.model.Orders;

public interface OrdersService {

void saveOrders(Orders order);
    
    List<Orders> findAllOrders();
     
    void deleteOrdersById(int id);
     
    Orders findById(int id);
     
    void updateOrders(Orders order);
    
    void deleteAllOrders();
    
}
