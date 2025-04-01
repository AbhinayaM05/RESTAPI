package com.example.demo.Service;
 import java.util.List;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.data.domain.Page;
 import org.springframework.data.domain.PageRequest;
 import org.springframework.data.domain.Pageable;
 import org.springframework.data.domain.Sort;
 import org.springframework.stereotype.Service;

import com.Entity.User;
import com.example.demo.Repository.UserRepo;

import jakarta.persistence.EntityNotFoundException;
 
 @Service
 public class UserService {
     @Autowired 
     UserRepo userRepository;
 
     public User addUser(User user){
         return userRepository.save(user);
     }
 
     public List<User> viewUser(){
         return userRepository.findAll();
     }
 
     public void deleteUser(Long id){
         if(userRepository.existsById(id)){
             userRepository.deleteById(id);
         }
         else{
             throw new EntityNotFoundException("User Not Found");
         }
     }
 
     public User updateUser(Long id, User userDetails){
         User existingUser = userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("User not found"));
         userDetails.setId(id);
         existingUser.setId(userDetails.getId());
         existingUser.setEmail(userDetails.getEmail());
         existingUser.setName(userDetails.getName());
         existingUser.setPassword(userDetails.getPassword());
 
         return userRepository.save(existingUser);
     }
 
 
     public Page<User> getMethod(int page,int size){
         Pageable pageable = PageRequest.of(page, size);
         return userRepository.findAll(pageable);
     }
 
     public List<User> sortbyName(){
         return userRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));
     }
 
     public List<User> getbyname(String name){
         return userRepository.findbyname(name);
     }
 
     public List<User> getByEmail(String email){
         return userRepository.findByEmail(email);
     }
 }
