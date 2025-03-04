package com.project.david.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.david.entity.Order;
import com.project.david.service.OrderService;
import com.project.david.service.ServiceException;

@RestController
@CrossOrigin
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	/*
	 * API 入口 : 建立訂單
	 * 
	 * 使用範例 : POST /api/orders/create?productId=1&quantity=2
	 */
	@PostMapping("/create/{productId}/{quantity}")
	public ResponseEntity<?> createOrder(@PathVariable("productId") Integer productId,
			@PathVariable("quantity") int quantity) {
		try {
			Order order = orderService.createOrder(productId, quantity);
			return new ResponseEntity<>(order, HttpStatus.OK);
		} catch (ServiceException e) {
			// 若發生異常(例如庫存不足，回傳錯誤資訊)
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
}
