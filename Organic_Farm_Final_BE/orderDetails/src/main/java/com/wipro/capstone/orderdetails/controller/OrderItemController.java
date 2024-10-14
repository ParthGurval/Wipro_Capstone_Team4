package com.wipro.capstone.orderdetails.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.capstone.orderdetails.dto.OrderItemDTO;
import com.wipro.capstone.orderdetails.entity.OrderItem;
import com.wipro.capstone.orderdetails.service.IOrderItemServiceImp;


@RestController
@RequestMapping("/api/orderItems")
public class OrderItemController {

    @Autowired
    private IOrderItemServiceImp orderItemService;
    
    // Create new order item
    @PostMapping(value="/createOrderItem")
    public OrderItem createOrderItem(@RequestBody OrderItemDTO orderItemDTO) {
        return orderItemService.createOrderItem(orderItemDTO);
    }
    
    // Get order item by ID
    @GetMapping(value="/getbyid/{order_item_id}")
    public OrderItemDTO getOrderItemById(@PathVariable Long order_item_id) {
        return orderItemService.getOrderItemById(order_item_id);
    }
    
    // Get all order items
    @GetMapping("/getallOrderItems")
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }
    
    // Update an order item
    @PutMapping("/updateOrderItem")
    public OrderItem updateOrderItem(@RequestBody OrderItemDTO orderItemDTO) {
        return orderItemService.updateOrderItem(orderItemDTO);
    }
    
    // Delete an order item by ID
    @DeleteMapping("/deletebyid/{order_item_id}")
    public String deleteOrderItemById(@PathVariable Long order_item_id) {
        return orderItemService.deleteOrderItem(order_item_id);
    }
}
