package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.Admin;
import com.example.demo.Repository.AdminRepository;

import java.util.List;

import jakarta.transaction.Transactional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Get all admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAllAdmins();
    }

    // Get admins with pagination
    public Page<Admin> getAdminsWithPagination(Pageable pageable) {
        return adminRepository.findAdminsWithPagination(pageable);
    }

    // Get admin by ID
    public Admin getAdminById(Long id) {
        return adminRepository.findAdminById(id);
    }

    // Create a new admin
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Delete an admin
    @Transactional
    public boolean deleteAdmin(Long id) {
        int deletedRows = adminRepository.deleteAdminById(id);
        return deletedRows > 0;
    }
}
