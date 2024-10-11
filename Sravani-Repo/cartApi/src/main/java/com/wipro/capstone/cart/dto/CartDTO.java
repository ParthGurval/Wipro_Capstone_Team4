package com.wipro.capstone.cart.dto;



public class CartDTO {

    private Long cart_id;
    private Long customer_id;
    private Long product_id;
    private Integer quantity;

    public CartDTO() {
        super();
    }

    public CartDTO(Long cart_id, Long customer_id, Long product_id, Integer quantity) {
        super();
        this.cart_id = cart_id;
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public Long getCart_id() {
        return cart_id;
    }

    public void setCart_id(Long cart_id) {
        this.cart_id = cart_id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
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

    @Override
    public String toString() {
        return "CartDTO [cart_id=" + cart_id + ", customer_id=" + customer_id + ", product_id=" + product_id
                + ", quantity=" + quantity + "]";
    }
}

