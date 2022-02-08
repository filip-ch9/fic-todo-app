package com.fic.todo.app.dto;

import com.fic.todo.app.model.enums.TodoCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

  private Long id;
  private String description;
  private String dateOfEntry;
  private TodoCategory todoCategory;
  private String username;
  private Long userId;
}
