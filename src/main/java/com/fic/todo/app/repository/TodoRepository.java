package com.fic.todo.app.repository;

import com.fic.todo.app.model.Todo;
import com.fic.todo.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

  List<Todo> findAllByUser(User user);
  void deleteAllByUser(User user);
}
