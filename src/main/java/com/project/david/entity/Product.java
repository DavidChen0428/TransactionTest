package com.project.david.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
 * 	商品 :
 * 		商品編號(id)
 * 		商品名稱(name)
 * 		商品庫存(stock)
 */

@Getter
@Setter
@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private int stock;
	
	public Product(String name, int stock) {
		super();
		this.name = name;
		this.stock = stock;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
