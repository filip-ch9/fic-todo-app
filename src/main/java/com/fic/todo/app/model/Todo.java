package com.fic.todo.app.model;

import com.fic.todo.app.model.enums.TodoCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TODO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "description")
  private String description;

  @Column(name = "date_of_entry")
  private String dateOfEntry;

  @Enumerated(EnumType.STRING)
  @Column(name = "todo_category")
  private TodoCategory todoCategory;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

}
