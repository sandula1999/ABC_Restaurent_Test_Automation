package com.example.Hotel_Reservation_System.Service;

import com.example.Hotel_Reservation_System.Entity.Admin;
import com.example.Hotel_Reservation_System.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin registerAdmin(Admin admin) {
        // Directly save the admin with plain text password
        return adminRepository.save(admin);
    }


    public Admin login(String userName, String password) {
        Admin admin = adminRepository.findByUserName(userName);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        } else {
            throw new ResourceNotFoundException("Invalid username or password");
        }
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id: " + id));
    }

    public Admin updateAdmin(Long id, Admin updatedAdmin) {
        return adminRepository.findById(id).map(admin -> {
            admin.setName(updatedAdmin.getName());
            admin.setAddress(updatedAdmin.getAddress());
            admin.setContactNo(updatedAdmin.getContactNo());
            admin.setEmail(updatedAdmin.getEmail());
            admin.setUserName(updatedAdmin.getUserName());
            admin.setPassword(updatedAdmin.getPassword()); // Directly set the password
            return adminRepository.save(admin);
        }).orElseThrow(() -> new ResourceNotFoundException("Admin not found with id: " + id));
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
