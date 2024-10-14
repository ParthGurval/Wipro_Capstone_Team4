package com.wipro.paypal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

@Service
public class PaypalService {

    @Autowired
    private APIContext apiContext;

    public Payment createPayment(
            Double total,
            String currency,
            String method,
            String intent,
            String description,
            String cancelUrl,
            String successUrl) throws PayPalRESTException {

        // Validate inputs
        if (total == null || total <= 0) {
            throw new IllegalArgumentException("Total amount must be greater than zero");
        }
        if (currency == null || currency.isEmpty()) {
            throw new IllegalArgumentException("Currency must not be empty");
        }
        if (method == null || method.isEmpty()) {
            throw new IllegalArgumentException("Payment method must not be empty");
        }
        if (intent == null || intent.isEmpty()) {
            throw new IllegalArgumentException("Payment intent must not be empty");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Payment description must not be empty");
        }
        if (cancelUrl == null || cancelUrl.isEmpty() || successUrl == null || successUrl.isEmpty()) {
            throw new IllegalArgumentException("Cancel and success URLs must not be empty");
        }

        Amount amount = new Amount();
        amount.setCurrency(currency);
        
        // Round total to 2 decimal places
        total = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
        amount.setTotal(String.format("%.2f", total));

        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod(method);

        Payment payment = new Payment();
        payment.setIntent(intent);
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelUrl);
        redirectUrls.setReturnUrl(successUrl);
        payment.setRedirectUrls(redirectUrls);

        // Create payment
        return payment.create(apiContext);
    }

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        if (paymentId == null || paymentId.isEmpty()) {
            throw new IllegalArgumentException("Payment ID must not be empty");
        }
        if (payerId == null || payerId.isEmpty()) {
            throw new IllegalArgumentException("Payer ID must not be empty");
        }

        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);

        // Execute payment
        return payment.execute(apiContext, paymentExecute);
    }
}
