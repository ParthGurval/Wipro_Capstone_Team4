package com.wipro.capstone.payment.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wipro.capstone.payment.dto.PaymentDTO;  // Import the PaymentDTO
import com.wipro.capstone.payment.entity.Payment;
import com.wipro.capstone.payment.entity.PaymentStatus;
import com.wipro.capstone.payment.repository.PaymentRepository;

class PaymentServiceImpTest {

    @InjectMocks
    private PaymentServiceImp paymentService;

    @Mock
    private PaymentRepository paymentRepository;

    // Common test data
    private PaymentDTO testPaymentDTO;  // Change to PaymentDTO
    private Payment testPayment;          // Keep the original Payment for comparison

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("Setting up the tests...");
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("Cleaning up after all tests...");
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize common test data
        testPayment = new Payment();
        testPayment.setPayment_id(1L);
        testPayment.setOrder_id(100L);
        testPayment.setPayment_date(LocalDate.now());
        testPayment.setAmount(250.00);
        testPayment.setPayment_method("Credit Card");
        testPayment.setStatus(PaymentStatus.SUCCESS);
        
        // Initialize PaymentDTO
        testPaymentDTO = new PaymentDTO(1L, 100L, LocalDate.now(), 250.00, "Credit Card", PaymentStatus.SUCCESS);
    }

    @Test
    void testCreatePayment() {
        // Arrange
        when(paymentRepository.save(any(Payment.class))).thenReturn(testPayment);

        // Act
        Payment result = paymentService.createPayment(testPaymentDTO);  // Use testPaymentDTO

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getPayment_id());
        assertEquals(250.00, result.getAmount());
        assertEquals(PaymentStatus.SUCCESS, result.getStatus());
    }

    @Test
    void testGetPaymentById() {
        // Arrange
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(testPayment));

        // Act
        PaymentDTO result = paymentService.getPaymentById(1L);  // Assuming this returns Payment object

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getPayment_id());
        assertEquals(PaymentStatus.SUCCESS, result.getStatus());
    }

    @Test
    void testGetAllPayments() {
        // Arrange
        List<Payment> payments = Arrays.asList(testPayment);
        when(paymentRepository.findAll()).thenReturn(payments);

        // Act
        List<Payment> result = paymentService.getAllPayments();

        // Assert
        assertEquals(1, result.size());
        assertEquals(testPayment, result.get(0));
    }

    @Test
    void testUpdatePayment() {
        // Arrange
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(testPayment));
        when(paymentRepository.save(any(Payment.class))).thenReturn(testPayment);

        // Act
        Payment result = paymentService.updatePayment(testPaymentDTO);  // Use testPaymentDTO

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getPayment_id());
        assertEquals(PaymentStatus.SUCCESS, result.getStatus());
    }

    @Test
    void testDeletePayment() {
        // Arrange
        Long paymentId = 1L;

        // Act
        paymentService.deletePayment(paymentId);

        // Assert
        verify(paymentRepository, times(1)).deleteById(paymentId);
    }
}
