package com.example.demo.Controller;
 
 import org.springframework.web.bind.annotation.*;

import com.Entity.Payment;
import com.example.demo.Service.PaymentService;

import java.util.List;
 
 @RestController
 @RequestMapping("/api/payments")
 public class PaymentController {
 
     private final PaymentService paymentService;
 
     public PaymentController(PaymentService paymentService) {
         this.paymentService = paymentService;
     }
 
     @GetMapping
     public List<Payment> getAllPayments() {
         return paymentService.getAllPayments();
     }
 
     @PostMapping
     public Payment createPayment(@RequestBody Payment payment) {
         return paymentService.savePayment(payment);
     }
 
     @DeleteMapping("/{id}")
     public void deletePayment(@PathVariable Long id) {
         paymentService.deletePayment(id);
     }
 }
