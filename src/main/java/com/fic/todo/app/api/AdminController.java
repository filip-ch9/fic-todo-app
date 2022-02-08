package com.fic.todo.app.api;

import com.fic.todo.app.dto.AdminDTO;
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
  public List<AdminDTO> getAllAdminUsers() {
    return adminMapper.convertListToDto(adminService.getAllAdminUsers());
  }

  @GetMapping("/{id}")
  public AdminDTO getAdmin(@PathVariable("id") Long id) {
    return adminMapper.convertToDto(adminService.getAdmin(id));
  }

  @PostMapping()
  public AdminDTO createAdmin(@RequestBody AdminDTO adminDto) {
    return adminMapper.convertToDto(adminService.createAdminUser(adminDto));
  }

  @PutMapping()
  public AdminDTO updateAdmin(@RequestBody AdminDTO adminDto) {
    return adminMapper.convertToDto(adminService.updateAdminUser(adminDto));
  }

  @DeleteMapping("{id}")
  public boolean deleteAdmin(@PathVariable("id") Long id) {
    return adminService.deleteAdminUser(id);
  }

}
