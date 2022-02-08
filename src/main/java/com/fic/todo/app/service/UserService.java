package com.fic.todo.app.service;

import com.fic.todo.app.dto.UserDTO;
import com.fic.todo.app.exceptions.TodoAppException;
import com.fic.todo.app.helper.TodoMapper;
import com.fic.todo.app.helper.UserMapper;
import com.fic.todo.app.model.User;
import com.fic.todo.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired private UserRepository userRepository;

  @Autowired private UserMapper userMapper;
  @Autowired private TodoMapper todoMapper;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserByUsername(String username){
    return userRepository.findByUsername(username).orElseThrow(() -> new TodoAppException("User does not exists! Username:" + username ));
  }

  public User createUser(UserDTO userDTO) {
    return userRepository.save(userMapper.convertFromDto(userDTO));
  }

  public User updateUser(UserDTO userDTO) {
    User user = userRepository.findByUsername(userDTO.getUsername()).orElseThrow(() -> new TodoAppException("User does not exists! Username:" + userDTO.getUsername()));
    user.setPassword(userDTO.getPassword());
    user.setConfirmPassword(userDTO.getConfirmPassword());
    user.setTodos(todoMapper.convertListFromTodoDto(userDTO.getTodoDTOList()));
    return user;
  }

  public boolean deleteUser(Long id) {
    userRepository.deleteById(id);
    return !userRepository.existsById(id);
  }

}
