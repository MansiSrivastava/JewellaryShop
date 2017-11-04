package com.backend.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.backend.spring.model.Orders;

@Repository("ordersDao")
public class OrdersDaoImpl extends AbstractDao implements OrdersDao{

	public void saveOrders(Orders order) {
		// TODO Auto-generated method stub
		persist(order);
	}

	@SuppressWarnings("unchecked")
	public List<Orders> findAllOrders() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Orders").list();
	}

	public void deleteOrdersById(int id) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("delete from Orders where o_id = :o_id");
		query.setInteger("o_id", id);
        query.executeUpdate();
	}

	public Orders findById(int id) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Orders.class);
        criteria.add(Restrictions.eq("id",id));
        return (Orders) criteria.uniqueResult();
	}

	public void updateOrders(Orders order) {
		// TODO Auto-generated method stub
		getSession().update(order);
	}

	public void deleteAllOrders() {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("delete from Orders");
		query.executeUpdate();
	}

}
