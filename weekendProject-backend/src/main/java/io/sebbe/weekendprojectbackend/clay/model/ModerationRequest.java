package io.sebbe.weekendprojectbackend.clay.model;

public class ModerationRequest {

  private String input;

  public ModerationRequest(String input) {
    this.input = input;
  }

  public String getInput() {
    return input;
  }

  public void setInput(String input) {
    this.input = input;
  }
}
