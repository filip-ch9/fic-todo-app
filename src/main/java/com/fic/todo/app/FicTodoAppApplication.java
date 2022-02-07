package com.fic.todo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FicTodoAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(FicTodoAppApplication.class, args);
  }

}
