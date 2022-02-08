package com.fic.todo.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

  private Long id;
  private String email;
  private String username;
  private String password;
  private String confirmPassword;
  private List<TodoDTO>  todoDTOList;

}
