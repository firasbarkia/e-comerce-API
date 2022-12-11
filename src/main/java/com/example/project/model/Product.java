package com.example.project.model;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data 
@Entity
@Table(name="products")
public class Product {
	//we need to make this class as JPA entity using the Entity annotation
	@Id //for a primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="product_name",nullable=false)
	private String productName;
	@Column(name="price")
	private String price;
	@Column(name="category")
	private String category;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	

}
