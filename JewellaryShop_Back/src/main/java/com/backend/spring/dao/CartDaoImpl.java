package com.backend.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.backend.spring.model.Cart;

@Repository("cartDao")
public class CartDaoImpl extends AbstractDao implements CartDao{

	public void saveCart(Cart cart) {
		// TODO Auto-generated method stub
		persist(cart);
	}

	@SuppressWarnings("unchecked")
	public List<Cart> findAllCarts() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Cart").list();
	}

	public void deleteCartById(int id) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("delete from Cart where cart_id = :cart_id");
		query.setInteger("cart_id", id);
        query.executeUpdate();
	}

	public Cart findById(int id) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Cart.class);
        criteria.add(Restrictions.eq("id",id));
        return (Cart) criteria.uniqueResult();
	}

	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub
		getSession().update(cart);
	}

	public void deleteAllCarts() {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("delete from Cart");
		query.executeUpdate();
	}

}
