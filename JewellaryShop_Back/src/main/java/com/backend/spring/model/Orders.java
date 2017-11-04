package com.backend.spring.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Orders implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "O_ID",unique = true, nullable = false)
	private int id;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name = "ORDERS_PRODUCTS", joinColumns = { @JoinColumn(name = "O_ID") }, inverseJoinColumns = { @JoinColumn(name = "PRODUCT_ID") })
	private Set<Product> productset;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CART_ID") 
	private Cart cart;
	
	private int quantity;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Cart getCart() {
		return cart;
	}
	
	public Set<Product> getProductset() {
		return productset;
	}
	public void setProductset(Set<Product> productset) {
		this.productset = productset;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
