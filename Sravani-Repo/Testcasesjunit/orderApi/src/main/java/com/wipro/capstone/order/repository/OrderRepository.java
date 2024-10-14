package com.wipro.capstone.order.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.capstone.order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	List<Order> findByCustomerId(Long customerId);
	
	List<Order> findByPartnerId(Long partnerId);
}

