package com.fic.todo.app.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "confirm_password")
  private String confirmPassword;

  @OneToMany(mappedBy = "user")
  private List<Todo> todos;

}
