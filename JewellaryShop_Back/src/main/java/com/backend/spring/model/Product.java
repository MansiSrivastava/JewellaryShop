package com.backend.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="PRODUCT")
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1587653004089613933L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private int quantity;
	
	@Column
	private float price;
	
	@Column
	private String status;
	
	@Column
	private String imagepath;
	
	@Transient
	private MultipartFile file;
	
	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name="O_ID",nullable=true)
	private Orders order;*/
	
	public Product() {
    }
 
    public Product(String name, String description, int quantity, int price, String status, String imagepath) {
        this.name=name;
        this.description=description;
        this.quantity=quantity;
        this.price=price;
        this.status=status;
        this.imagepath=imagepath;
    }

	public int getId() {
		return id;
	}

	/*public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}*/

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
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

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
