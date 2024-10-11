package com.wipro.capstone.payment.controller;

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
import com.wipro.capstone.payment.dto.PaymentDTO;
import com.wipro.capstone.payment.entity.Payment;
import com.wipro.capstone.payment.service.PaymentServiceImp;


@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentServiceImp paymentService;
    
    @PostMapping(value="/createPayment")
    public Payment createPayment(@RequestBody PaymentDTO paymentDTO) {
        return paymentService.createPayment(paymentDTO);
    }
    
    @GetMapping(value="/getbyid/{payment_id}")
    public PaymentDTO getPaymentById(@PathVariable Long payment_id) {
        return paymentService.getPaymentById(payment_id);
    }
    
    @GetMapping("/getallPayments")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }
    
    @PutMapping("/updatePayment")
    public Payment updatePayment(@RequestBody PaymentDTO paymentDTO) {
        return paymentService.updatePayment(paymentDTO);
    }
    
    @DeleteMapping("/deletebyid/{payment_id}")
    public String deletePaymentById(@PathVariable Long payment_id) {
        return paymentService.deletePayment(payment_id);
    }
}
