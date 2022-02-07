package com.fic.todo.app.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class TodoAppException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public TodoAppException() {
    super();
  }

  public TodoAppException(Throwable cause) {
    super(cause);
  }

  public TodoAppException(String cause) {
    super(cause);
  }

}

