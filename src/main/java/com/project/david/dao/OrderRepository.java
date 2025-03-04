package com.project.david.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.david.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{

}
