package com.fic.todo.app.helper;

import com.fic.todo.app.dto.TodoDTO;
import com.fic.todo.app.model.Todo;
import com.fic.todo.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoMapper {

  @Autowired private UserService userService;

  public Todo convertFromDto(TodoDTO dto) {
    Todo todo = new Todo();
    todo.setDescription(dto.getDescription());
    todo.setDateOfEntry(dto.getDateOfEntry());
    todo.setTodoCategory(dto.getTodoCategory());
    todo.setUser(userService.getUserByUsername(dto.getUsername()));
    return todo;
  }

  public TodoDTO convertToDto(Todo todo) {
    TodoDTO dto = new TodoDTO();
    dto.setDescription(todo.getDescription());
    dto.setDateOfEntry(todo.getDateOfEntry());
    dto.setTodoCategory(todo.getTodoCategory());
    dto.setUsername(todo.getUser().getUsername());
    dto.setUserId(todo.getUser().getId());
    return dto;
  }

  public List<TodoDTO> convertListToTodoDto(List<Todo> todoList) {
    return todoList.stream().map(this::convertToDto).collect(Collectors.toList());
  }

  public List<Todo> convertListFromTodoDto(List<TodoDTO> todoList) {
    return todoList.stream().map(this::convertFromDto).collect(Collectors.toList());
  }

}
