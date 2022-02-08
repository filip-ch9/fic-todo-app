package com.fic.todo.app.service;

import com.fic.todo.app.dto.TodoDTO;
import com.fic.todo.app.exceptions.TodoAppException;
import com.fic.todo.app.helper.TodoMapper;
import com.fic.todo.app.model.Todo;
import com.fic.todo.app.model.User;
import com.fic.todo.app.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

  @Autowired private TodoRepository todoRepository;

  @Autowired private TodoMapper todoMapper;

  @Autowired private UserService userService;

  public List<Todo> getAllByUser(User user) {
    return todoRepository.findAllByUser(user);
  }

  public Todo createTodo(TodoDTO todoDTO) {
    return todoRepository.save(todoMapper.convertFromDto(todoDTO));
  }

  public List<Todo> createMultipleTodos(List<TodoDTO> todoDTOList) {
    return todoRepository.saveAll(todoMapper.convertListFromTodoDto(todoDTOList));
  }

  public List<Todo> updateTodos(TodoDTO todoDTO) {
    List<Todo> todoList = todoRepository.findAllByUser(userService.getUserByUsername(todoDTO.getUsername()));
    todoList.forEach(todo -> {
      todo.setDescription(todoDTO.getDescription());
      todo.setDateOfEntry(todoDTO.getDateOfEntry());
      todo.setTodoCategory(todoDTO.getTodoCategory());
    });
    return todoList;
  }

  public Todo updateOneTodo(TodoDTO todoDTO) {
    Todo todo = todoRepository.findById(todoDTO.getId()).orElseThrow(() -> new TodoAppException("Todo does not exists! Id: " + todoDTO.getId()));
    todo.setDescription(todoDTO.getDescription());
    todo.setDateOfEntry(todoDTO.getDateOfEntry());
    todo.setTodoCategory(todoDTO.getTodoCategory());
    return todo;
  }

  public boolean deleteTodo(Long id) {
    todoRepository.deleteById(id);
    return !todoRepository.existsById(id);
  }

}
