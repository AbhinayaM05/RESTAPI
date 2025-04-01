package com.Entity;
 
 import jakarta.persistence.*;
 
 @Entity
 public class Payment {
 
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
 
     private Long memberId;
     private double amount;
     private String paymentMethod;
     public Long getId() {
         return id;
     }
     public void setId(Long id) {
         this.id = id;
     }
     public Long getMemberId() {
         return memberId;
     }
     public void setMemberId(Long memberId) {
         this.memberId = memberId;
     }
     public double getAmount() {
         return amount;
     }
     public void setAmount(double amount) {
         this.amount = amount;
     }
     public String getPaymentMethod() {
         return paymentMethod;
     }
     public void setPaymentMethod(String paymentMethod) {
         this.paymentMethod = paymentMethod;
     }
 }
