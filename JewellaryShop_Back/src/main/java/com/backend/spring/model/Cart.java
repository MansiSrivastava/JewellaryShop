package com.backend.spring.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Cart")
public class Cart{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cart_id")
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private User user;
	
	@OneToMany(cascade=CascadeType.ALL,targetEntity=Orders.class,mappedBy = "cart",fetch=FetchType.EAGER)
	private Set<Orders> orderset;
	//private List<Orders> orderset;
	
	
	public Cart(){
		
	}
	
	public Cart(User user){
		this.user=user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Set<Orders> getOrderset() {
		return orderset;
	}

	public void setOrderset(Set<Orders> orderset) {
		this.orderset = orderset;
	}
	
}
