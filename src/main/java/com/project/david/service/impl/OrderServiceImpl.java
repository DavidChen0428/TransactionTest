package com.project.david.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.david.dao.OrderRepository;
import com.project.david.dao.ProductRepository;
import com.project.david.entity.Order;
import com.project.david.entity.Product;
import com.project.david.service.OrderService;
import com.project.david.service.ServiceException;
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductRepository productRepository;

	/*
	 * 	創建一筆訂單，同時扣減商品庫存
	 * 	若商品不存在或是庫存不足，均丟出例外並回滾交易
	 * 
	 * 	@param productId 商品Id
	 * 	@param quantity 訂購數量
	 * 	@return 建立完成的訂單
	 * 	@throws Exception 異常訊息
	 */
	@Transactional(rollbackFor=ServiceException.class)
	@Override
	public Order createOrder(Integer productId, int quantity) throws ServiceException {
		// 取得商品資訊
		Product product=productRepository.findById(productId).orElseThrow(()->new ServiceException("找不到商品，ID: "+productId));
		
		// 檢查庫存是否足夠
		if(product.getStock()<quantity) {
			throw new ServiceException("商品 "+product.getName()+" 庫存不足，當前庫存: "+product.getStock());
		}
		
		// 扣減庫存
		product.setStock(product.getStock()-quantity);
		productRepository.save(product);
		
		// 建立訂單
		Order order=new Order();
		order.setProduct(product);
		order.setQuantity(quantity);
		order.setOrderDate(new Date());
		orderRepository.save(order);
		return order;
	}
	
}
