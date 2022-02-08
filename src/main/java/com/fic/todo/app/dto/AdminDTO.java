package com.fic.todo.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {

  private Long id;
  private String email;
  private String username;
  private String password;
  private String confirmPassword;
}
