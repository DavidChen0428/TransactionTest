package com.project.david.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	// 一筆訂單對應一個商品，多筆訂單對應同一個商品
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	private int quantity;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
