package com.fic.todo.app.helper;

import com.fic.todo.app.dto.UserDTO;
import com.fic.todo.app.model.User;
import com.fic.todo.app.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

  @Autowired private TodoMapper todoMapper;

  @Autowired private TodoService todoService;

  public User convertFromDto(UserDTO dto) {
    User user = new User();
    user.setEmail(dto.getEmail());
    user.setUsername(dto.getUsername());
    user.setPassword(dto.getPassword());
    user.setConfirmPassword(dto.getConfirmPassword());
    if (!dto.getTodoDTOList().isEmpty() || dto.getTodoDTOList() != null) {
      user.setTodos(todoMapper.convertListFromTodoDto(dto.getTodoDTOList()));
    }
    return user;
  }

  public UserDTO convertToDto(User user) {
    UserDTO dto = new UserDTO();
    dto.setEmail(user.getEmail());
    dto.setUsername(user.getUsername());
    dto.setPassword(user.getPassword());
    dto.setConfirmPassword(user.getConfirmPassword());
    if (!user.getTodos().isEmpty() || user.getTodos() != null) {
      dto.setTodoDTOList(todoMapper.convertListToTodoDto(todoService.getAllByUser(user)));
    }
    return dto;
  }

  public List<UserDTO> convertListToUserDto(List<User> userList) {
    return userList.stream().map(this::convertToDto).collect(Collectors.toList());
  }
}
