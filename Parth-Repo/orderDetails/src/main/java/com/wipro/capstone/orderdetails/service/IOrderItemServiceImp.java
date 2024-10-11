package com.wipro.capstone.orderdetails.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.capstone.orderdetails.dto.OrderItemDTO;
import com.wipro.capstone.orderdetails.entity.OrderItem;
import com.wipro.capstone.orderdetails.repository.OrderItemRepository;

	
	@Service
	public class IOrderItemServiceImp implements IOrderItemService {

	    @Autowired
	    private OrderItemRepository orderItemRepository;

	    @Override
	    public OrderItem createOrderItem(OrderItemDTO orderItemDTO) {
	        OrderItem orderItem = new OrderItem();
	        
	        orderItem.setOrder_id(orderItemDTO.getOrder_id());
	        orderItem.setProduct_id(orderItemDTO.getProduct_id());
	        orderItem.setQuantity(orderItemDTO.getQuantity());
	        orderItem.setPrice(orderItemDTO.getPrice());

	        return orderItemRepository.save(orderItem);
	    }

	    @Override
	    public OrderItemDTO getOrderItemById(Long order_item_id) {
	        OrderItem orderItem = orderItemRepository.findById(order_item_id).orElse(null);

	        OrderItemDTO orderItemDto = new OrderItemDTO();
	        orderItemDto.setOrder_item_id(orderItem.getOrder_item_id());
	        orderItemDto.setOrder_id(orderItem.getOrder_id());
	        orderItemDto.setProduct_id(orderItem.getProduct_id());
	        orderItemDto.setQuantity(orderItem.getQuantity());
	        orderItemDto.setPrice(orderItem.getPrice());

	        return orderItemDto;
	    }

	    @Override
	    public List<OrderItem> getAllOrderItems() {
	        return orderItemRepository.findAll();
	    }

	    @Override
	    public OrderItem updateOrderItem(OrderItemDTO orderItemDTO) {
	        OrderItem orderItem = new OrderItem();
	        
	        orderItem.setOrder_item_id(orderItemDTO.getOrder_item_id());
	        orderItem.setOrder_id(orderItemDTO.getOrder_id());
	        orderItem.setProduct_id(orderItemDTO.getProduct_id());
	        orderItem.setQuantity(orderItemDTO.getQuantity());
	        orderItem.setPrice(orderItemDTO.getPrice());

	        return orderItemRepository.save(orderItem);
	    }

	    @Override
	    public String deleteOrderItem(Long order_item_id) {
	        orderItemRepository.deleteById(order_item_id);
	        return "Record Deleted For OrderItem ID: " + order_item_id;
	    }
	}

	
	

