package com.wipro.capstone.orderdetails.dto;



import java.time.LocalDate;

public class Order {

    private Long order_id; // Primary key

    private Long customer_id; // Foreign key (relationship to customer)

    private LocalDate order_date; // Order date

    private Double total_amount; // Total amount for the order

    public Order() {
        super();
    }

    public Order(Long order_id, Long customer_id, LocalDate order_date, Double total_amount) {
        super();
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.order_date = order_date;
        this.total_amount = total_amount;
    }

    // Getters and Setters
    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public LocalDate getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDate order_date) {
        this.order_date = order_date;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    @Override
    public String toString() {
        return "OrderDTO [order_id=" + order_id + ", customer_id=" + customer_id + ", order_date=" + order_date
                + ", total_amount=" + total_amount + "]";
    }
}

