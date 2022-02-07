package com.fic.todo.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {

  private Long id;
  private String email;
  private String username;
  private String password;
  private String confirmPassword;
}
