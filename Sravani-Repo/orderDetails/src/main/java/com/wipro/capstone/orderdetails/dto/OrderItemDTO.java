package com.wipro.capstone.orderdetails.dto;

public class OrderItemDTO {

    private Long order_item_id; // Primary key

    private Long order_id; // Foreign key (relationship to order)

    private Long product_id; // Foreign key (relationship to product)

    private Integer quantity; // Quantity of the product in the order

    private Double price; // Price for the product in the order

    public OrderItemDTO() {
        super();
    }

    public OrderItemDTO(Long order_item_id, Long order_id, Long product_id, Integer quantity, Double price) {
        super();
        this.order_item_id = order_item_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public Long getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(Long order_item_id) {
        this.order_item_id = order_item_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItemDTO [order_item_id=" + order_item_id + ", order_id=" + order_id + ", product_id=" + product_id
                + ", quantity=" + quantity + ", price=" + price + "]";
    }
}

