package com.wipro.capstone.orderdetails.dto;



public class OrderOrderItemVO {

    private Order order;
    private OrderItemDTO orderItem;

    public OrderOrderItemVO() {
        // Default constructor
    }

    public OrderOrderItemVO(Order order, OrderItemDTO orderItem) {
        super();
        this.order = order;
        this.orderItem = orderItem;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderItemDTO getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItemDTO orderItem) {
        this.orderItem = orderItem;
    }

    @Override
    public String toString() {
        return "OrderOrderItemVO [order=" + order + ", orderItem=" + orderItem + "]";
    }
}

