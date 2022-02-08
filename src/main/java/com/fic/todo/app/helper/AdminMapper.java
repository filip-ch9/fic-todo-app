package com.fic.todo.app.helper;

import com.fic.todo.app.dto.AdminDTO;
import com.fic.todo.app.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdminMapper {

  public Admin convertFromDto(AdminDTO adminDto) {
    return new Admin(adminDto.getEmail(), adminDto.getUsername(),
        adminDto.getPassword(), adminDto.getConfirmPassword());
  }

  public AdminDTO convertToDto(Admin admin) {
    return new AdminDTO(admin.getId(), admin.getEmail(), admin.getUsername(),
        admin.getPassword(), admin.getConfirmPassword());
  }

  public List<AdminDTO> convertListToDto(List<Admin> adminList) {
    return adminList.stream().map(this::convertToDto).collect(Collectors.toList());
  }

}
