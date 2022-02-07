package com.fic.todo.app.api;

import com.fic.todo.app.dto.AdminDto;
import com.fic.todo.app.helper.AdminMapper;
import com.fic.todo.app.service.AdminService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "admin-controller", description = "AdminController")
@RestController
@RequestMapping(value = "/admin")
public class AdminController {

  @Autowired private AdminService adminService;
  @Autowired private AdminMapper adminMapper;

  @GetMapping()
  public List<AdminDto> getAllAdminUsers() {
    return adminMapper.convertListToDto(adminService.getAllAdminUsers());
  }

  @GetMapping("/{id}")
  public AdminDto getAdmin(@PathVariable("id") Long id) {
    return adminMapper.convertToDto(adminService.getAdmin(id));
  }

  @PostMapping()
  public AdminDto createAdmin(@RequestBody AdminDto adminDto) {
    return adminMapper.convertToDto(adminService.createAdminUser(adminDto));
  }

  @PutMapping()
  public AdminDto updateAdmin(@RequestBody AdminDto adminDto) {
    return adminMapper.convertToDto(adminService.updateAdminUser(adminDto));
  }

  @DeleteMapping("{id}")
  public void deleteAdmin(@PathVariable("id") Long id) {
    adminService.deleteAdminUser(id);
  }

}
