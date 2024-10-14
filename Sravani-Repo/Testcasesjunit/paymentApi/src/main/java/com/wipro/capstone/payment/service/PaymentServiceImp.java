package com.wipro.capstone.payment.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.capstone.payment.dto.PaymentDTO;
import com.wipro.capstone.payment.entity.Payment;
import com.wipro.capstone.payment.repository.PaymentRepository;

@Service
public class PaymentServiceImp implements IPaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        
        payment.setOrder_id(paymentDTO.getOrder_id());
        payment.setPayment_date(paymentDTO.getPayment_date());
        payment.setAmount(paymentDTO.getAmount());
        payment.setPayment_method(paymentDTO.getPayment_method());
        payment.setStatus(paymentDTO.getStatus());

        return paymentRepository.save(payment);
    }

    @Override
    public PaymentDTO getPaymentById(Long payment_id) {
        Payment payment = paymentRepository.findById(payment_id).orElse(null);

        PaymentDTO paymentDto = new PaymentDTO();
        paymentDto.setPayment_id(payment.getPayment_id());
        paymentDto.setOrder_id(payment.getOrder_id());
        paymentDto.setPayment_date(payment.getPayment_date());
        paymentDto.setAmount(payment.getAmount());
        paymentDto.setPayment_method(payment.getPayment_method());
        paymentDto.setStatus(payment.getStatus());

        return paymentDto;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment updatePayment(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        
        payment.setPayment_id(paymentDTO.getPayment_id());
        payment.setOrder_id(paymentDTO.getOrder_id());
        payment.setPayment_date(paymentDTO.getPayment_date());
        payment.setAmount(paymentDTO.getAmount());
        payment.setPayment_method(paymentDTO.getPayment_method());
        payment.setStatus(paymentDTO.getStatus());

        return paymentRepository.save(payment);
    }

    @Override
    public String deletePayment(Long payment_id) {
        paymentRepository.deleteById(payment_id);
        return "Record Deleted For Payment ID: " + payment_id;
    }
}

