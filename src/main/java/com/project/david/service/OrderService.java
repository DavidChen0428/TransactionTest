package com.project.david.service;

import com.project.david.entity.Order;

public interface OrderService {
	// 新增訂單 -> 消耗商品
	Order createOrder(Integer productId,int quantity) throws ServiceException;
}
