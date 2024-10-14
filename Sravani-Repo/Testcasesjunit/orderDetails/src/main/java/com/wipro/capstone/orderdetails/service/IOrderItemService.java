package com.wipro.capstone.orderdetails.service;



import java.util.List;

import com.wipro.capstone.orderdetails.dto.OrderItemDTO;
import com.wipro.capstone.orderdetails.entity.OrderItem;



public interface IOrderItemService {

    public OrderItem createOrderItem(OrderItemDTO orderItemDTO);
    
    public OrderItemDTO getOrderItemById(Long order_item_id);
    
    public List<OrderItem> getAllOrderItems();
    
    public OrderItem updateOrderItem(OrderItemDTO orderItemDTO);
    
    public String deleteOrderItem(Long order_item_id);
}

