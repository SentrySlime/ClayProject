package io.sebbe.weekendprojectbackend.clay.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Clay {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String input;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getInput() {
    return input;
  }

  public void setInput(String input) {
    this.input = input;
  }
}