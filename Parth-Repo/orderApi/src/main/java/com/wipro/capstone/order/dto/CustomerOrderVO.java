package com.wipro.capstone.order.dto;



public class CustomerOrderVO {

    private Customer customer;  // Customer details
    private OrderDTO order;     // Order details

    public CustomerOrderVO() {
        // Default constructor
    }

    public CustomerOrderVO(Customer customer, OrderDTO order) {
        this.customer = customer;
        this.order = order;
    }

    // Getters and Setters
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "CustomerOrderVO [customer=" + customer + ", order=" + order + "]";
    }
    
    
}

