package com.project.david.service;

import com.project.david.entity.Order;

public interface OrderService {
	Order createOrder(Integer productId,int quantity) throws ServiceException;
}
