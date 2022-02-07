package com.fic.todo.app.model.enums;

public enum TodoCategory {

  LIFE("life"),
  WORK("work"),
  IMPORTANT("important"),
  PERSONAL("personal"),
  SHOPPING("shopping");

  private final String nameOfCategory;

  private TodoCategory(String nameOfCategory) {
    this.nameOfCategory = nameOfCategory;
  }

  public String getNameOfCatgory() {
    return nameOfCategory;
  }

}

