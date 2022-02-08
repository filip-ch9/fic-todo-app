package com.fic.todo.app.service;

import com.fic.todo.app.dto.AdminDTO;
import com.fic.todo.app.exceptions.TodoAppException;
import com.fic.todo.app.helper.AdminMapper;
import com.fic.todo.app.model.Admin;
import com.fic.todo.app.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

  @Autowired private AdminRepository adminRepository;

  @Autowired private AdminMapper adminMapper;

  public Admin createAdminUser(AdminDTO adminDto) {
    return adminRepository.save(adminMapper.convertFromDto(adminDto));
  }

  public List<Admin> getAllAdminUsers() {
    return adminRepository.findAll();
  }

  public Admin getAdmin(Long id) {
    return adminRepository.findById(id).orElseThrow(() -> new TodoAppException("Admin does not exist! Id: " + id));
  }

  public Admin updateAdminUser(AdminDTO adminDto) {
    Admin admin = adminRepository.findById(adminDto.getId())
        .orElseThrow(() -> new TodoAppException("Admin does not exist! Id: " + adminDto.getId()));
    admin.setId(adminDto.getId());
    admin.setEmail(adminDto.getEmail());
    admin.setUsername(adminDto.getUsername());
    admin.setPassword(adminDto.getPassword());
    admin.setConfirmPassword(adminDto.getConfirmPassword());
    return adminRepository.save(admin);
  }

  public boolean deleteAdminUser(Long id) {
    adminRepository.deleteById(id);
    return !adminRepository.existsById(id);
  }

}
