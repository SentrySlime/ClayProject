package io.sebbe.weekendprojectbackend.clay.model;

import jakarta.persistence.*;

@Entity
public class AppUser {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String name;

  private String gender;

  private String info;

  @OneToOne
  private InfoScoring infoScoring;

  public AppUser() {
  }

  public AppUser(String name, String gender, String info) {
    this.name = name;
    this.gender = gender;
    this.info = info;
  }


  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }
}