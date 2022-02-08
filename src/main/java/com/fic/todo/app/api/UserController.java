package com.fic.todo.app.api;

import com.fic.todo.app.dto.UserDTO;
import com.fic.todo.app.helper.UserMapper;
import com.fic.todo.app.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "user-controller", description = "UserController")
@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired private UserService userService;

  @Autowired private UserMapper userMapper;

  @GetMapping("/{username}")
  public UserDTO getUser(@PathVariable("username") String username) {
    return userMapper.convertToDto(userService.getUserByUsername(username));
  }

  @PostMapping()
  public UserDTO createUser(@RequestBody UserDTO userDTO) {
    return userMapper.convertToDto(userService.createUser(userDTO));
  }

  @PutMapping("{id}")
  public UserDTO updateUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
    return userMapper.convertToDto(userService.updateUser(id, userDTO));
  }

  @DeleteMapping("{id}")
  public boolean deleteUser(@PathVariable("id") Long id) {
    return userService.deleteUser(id);
  }

}
