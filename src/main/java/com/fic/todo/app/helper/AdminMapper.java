package com.fic.todo.app.helper;

import com.fic.todo.app.dto.AdminDto;
import com.fic.todo.app.service.AdminService;
import com.fic.todo.app.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdminMapper {

  @Autowired private AdminService adminService;

  public Admin convertFromDto(Admin adminDto) {
    return new Admin(adminDto.getEmail(), adminDto.getUsername(),
        adminDto.getPassword(), adminDto.getConfirmPassword());
  }

  public AdminDto convertToDto(Admin admin) {
    return new AdminDto(admin.getId(), admin.getEmail(), admin.getUsername(),
        admin.getPassword(), admin.getConfirmPassword());
  }

  public List<AdminDto> convertListToDto(List<Admin> adminList) {
    return adminList.stream().map(this::convertToDto).collect(Collectors.toList());
  }

}
