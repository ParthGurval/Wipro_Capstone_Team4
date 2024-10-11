package com.wipro.capstone.payment.service;

import java.util.List;
import com.wipro.capstone.payment.dto.PaymentDTO;
import com.wipro.capstone.payment.entity.Payment;

public interface IPaymentService {

    public Payment createPayment(PaymentDTO paymentDTO);
    
    public PaymentDTO getPaymentById(Long payment_id);
    
    public List<Payment> getAllPayments();
    
    public Payment updatePayment(PaymentDTO paymentDTO);
    
    public String deletePayment(Long payment_id);
}
