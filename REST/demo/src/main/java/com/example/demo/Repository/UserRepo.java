package com.example.demo.Repository;
 import java.util.List;
 
 import org.springframework.data.jpa.repository.*;
 import org.springframework.data.repository.query.Param;

import com.Entity.User;
 
 public interface UserRepo extends JpaRepository<User,Long>{
     @Query("SELECT u FROM User u WHERE u.name = :name")
     List<User> findbyname(@Param("name") String name);
 
     List<User> findByEmail(String email);
 }
