package com.example.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Entity.Admin;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    // Get all admins
    @Query("SELECT a FROM Admin a")
    List<Admin> findAllAdmins();

    // Get admins with pagination
    @Query("SELECT a FROM Admin a")
    Page<Admin> findAdminsWithPagination(Pageable pageable);

    // Get admin by ID
    @Query("SELECT a FROM Admin a WHERE a.id = :id")
    Admin findAdminById(@Param("id") Long id);

    // Delete an admin by ID using JPQL
    @Modifying
    @Transactional
    @Query("DELETE FROM Admin a WHERE a.id = :id")
    int deleteAdminById(@Param("id") Long id);
}
