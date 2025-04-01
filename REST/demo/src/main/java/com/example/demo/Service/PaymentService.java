package com.example.demo.Service;
 
 import org.springframework.stereotype.Service;

import com.Entity.Payment;
import com.example.demo.Repository.PaymentRepo;

import java.util.List;
 import java.util.Optional;
 
 @Service
 public class PaymentService {
 
     private final PaymentRepo paymentRepository;
 
     public PaymentService(PaymentRepo paymentRepository) {
         this.paymentRepository = paymentRepository;
     }
 
     public List<Payment> getAllPayments() {
         return paymentRepository.findAll();
     }
 
     public Optional<Payment> getPaymentById(Long id) {
         return paymentRepository.findById(id);
     }
 
     public Payment savePayment(Payment payment) {
         return paymentRepository.save(payment);
     }
 
     public void deletePayment(Long id) {
         paymentRepository.deleteById(id);
     }
 }