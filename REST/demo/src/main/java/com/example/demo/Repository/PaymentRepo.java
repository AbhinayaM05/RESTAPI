package com.example.demo.Repository;
 
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

import com.Entity.Payment;
 
 @Repository
 public interface PaymentRepo extends JpaRepository<Payment, Long> {
 }