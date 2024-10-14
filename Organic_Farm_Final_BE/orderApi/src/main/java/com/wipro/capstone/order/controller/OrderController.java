package com.wipro.capstone.order.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.capstone.order.dto.CustomerOrderVO;
import com.wipro.capstone.order.dto.FarmPartnerOrderVO;
import com.wipro.capstone.order.dto.OrderDTO;
import com.wipro.capstone.order.entity.Order;
import com.wipro.capstone.order.entity.OrderStatus;
import com.wipro.capstone.order.service.IOrderServiceImp;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private IOrderServiceImp orderService;
    
    // Create new order
    @PostMapping(value="/createOrder")
    public Order createOrder(@RequestBody OrderDTO orderDTO){
        return orderService.createOrder(orderDTO);
    }
    
    // Get order by ID
    @GetMapping(value="/getbyid/{order_id}")
    public OrderDTO getOrderById(@PathVariable Long order_id) {
        return orderService.getOrderById(order_id);
    }
    
    // Get all orders
    @GetMapping("/getallOrders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    
    // Update an order
    @PutMapping("/updateOrder")
    public Order updateOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.updateOrder(orderDTO);
    }
    
    // Update the status of an order
    @PutMapping("/updateOrderStatus/{order_id}")
    public Order updateOrderStatus(@PathVariable Long order_id, @RequestBody OrderStatus status) {
        return orderService.updateOrderStatus(order_id, status);
    }

    // Delete an order by ID
    @DeleteMapping("/deletebyid/{order_id}")
    public String deleteOrderById(@PathVariable Long order_id) {
        return orderService.deleteOrder(order_id);
    }
    
    
    //Access Order by Customer ID
    @GetMapping("/customer/{customerId}")
    public List<OrderDTO> getOrdersByCustomerId(@PathVariable Long customerId) {
        return orderService.getOrdersByCustomerId(customerId);
    }
    
    //Here we get all the customer info with help of orderId
    @GetMapping("/get/customer-oder/{order_id}")
    public CustomerOrderVO getCustByOrder(@PathVariable Long order_id) {
    	
    	return orderService.getCustomerByOrder(order_id);
    }
    
    @GetMapping("/get/farmPartner-order/{order_id}")
    public FarmPartnerOrderVO getPartnerByOrder(@PathVariable Long order_id) {
    	
    	return orderService.getFarmPartnerByOrder(order_id);
    }
    
    @GetMapping("/farmPartner/{partnerId}")
    public List<OrderDTO> getByFarmPartnerId(@PathVariable Long partnerId){
    	
    	return orderService.getOrderByFarmPartnerId(partnerId);
    }
}
