package com.backend.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.backend.spring.model.Product;
 
@Repository("productDao")
public class ProductDaoImpl extends AbstractDao implements ProductDao{

	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		persist(product);
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		//Criteria criteria = getSession().createCriteria(Product.class);
        return getSession().createQuery("from Product").list();
	}

	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("delete from Product where product_id = :product_id");
		query.setInteger("product_id", id);
        query.executeUpdate();
	}

	public Product findById(int id) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Product.class);
        criteria.add(Restrictions.eq("id",id));
        return (Product) criteria.uniqueResult();
	}

	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		getSession().update(product);
	}

	public void deleteAllProducts() {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("delete from Product");
		query.executeUpdate();
	}
    
}
