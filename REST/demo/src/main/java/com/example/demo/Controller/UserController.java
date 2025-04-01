package com.example.demo.Controller;
 import java.util.List;
 
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.data.domain.Page;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

import com.Entity.User;
import com.example.demo.Service.UserService;
 
 @RestController
 @RequestMapping("/user")
 public class UserController {
     @Autowired 
     UserService userService;
 
     @PostMapping("/add")
     public User addUser(@RequestBody User user){
         return userService.addUser(user);
     }
 
     @GetMapping("/view")
     public List<User> viewUser(){
         return userService.viewUser();
     }
 
     @DeleteMapping("/delete/{id}")
     public ResponseEntity<String> deleteUser(@PathVariable Long id){
         userService.deleteUser(id);
         return ResponseEntity.ok("User Deleted successfully");
     }
 
     @PutMapping("/update/{id}")
     public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
         User updatedUser= userService.updateUser(id, user);
         return ResponseEntity.ok(updatedUser);
     }
 
     @GetMapping("pagination")
     public Page<User> getMethod(@RequestParam int page,@RequestParam int size){
         return userService.getMethod(page,size);
     }
 
     @GetMapping("/sorted")
     public List<User> sortbyName(){
         return userService.sortbyName();
     }
 
     @GetMapping("/jpql")
     public List<User> getbyname(@RequestParam("name") String name){
         return userService.getbyname(name);
     }
 
     @GetMapping("/custom-jpa")
     public List<User> getByEmail(@RequestParam("email") String email){
         return userService.getByEmail(email);
     }
 }