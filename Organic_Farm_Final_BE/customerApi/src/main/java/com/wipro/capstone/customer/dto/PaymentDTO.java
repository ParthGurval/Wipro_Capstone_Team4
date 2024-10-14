package com.wipro.capstone.customer.dto;

import java.time.LocalDate;



public class PaymentDTO {

    private Long payment_id;
    private Long order_id;
    private LocalDate payment_date;
    private Double amount;
    private String payment_method;
    private PaymentStatus status;

    public PaymentDTO() {}

    public PaymentDTO(Long payment_id, Long order_id, LocalDate payment_date, Double amount, String payment_method, PaymentStatus status) {
        this.payment_id = payment_id;
        this.order_id = order_id;
        this.payment_date = payment_date;
        this.amount = amount;
        this.payment_method = payment_method;
        this.status = status;
    }

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public LocalDate getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDate payment_date) {
        this.payment_date = payment_date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}

