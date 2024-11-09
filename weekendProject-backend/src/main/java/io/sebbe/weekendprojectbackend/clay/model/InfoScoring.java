package io.sebbe.weekendprojectbackend.clay.model;

import jakarta.persistence.*;

@Entity
public class InfoScoring {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @OneToOne
  private AppUser appUser;

  public InfoScoring() {
  }

  public InfoScoring(AppUser appUser) {
    this.appUser = appUser;
  }

  public InfoScoring(AppUser appUser, double sexual, double hate, double harassment, double selfHarm, double sexualMinors, double hateThreatening, double violenceGraphic, double selfHarmIntent, double selfHarmInstructions, double harassmentThreatening, double violence) {
    this.appUser = appUser;
    this.sexual = sexual;
    this.hate = hate;
    this.harassment = harassment;
    this.selfHarm = selfHarm;
    this.sexualMinors = sexualMinors;
    this.hateThreatening = hateThreatening;
    this.violenceGraphic = violenceGraphic;
    this.selfHarmIntent = selfHarmIntent;
    this.selfHarmInstructions = selfHarmInstructions;
    this.harassmentThreatening = harassmentThreatening;
    this.violence = violence;
  }

  private double sexual;
  private double hate;
  private double harassment;
  private double selfHarm;
  private double sexualMinors;
  private double hateThreatening;
  private double violenceGraphic;
  private double selfHarmIntent;
  private double selfHarmInstructions;
  private double harassmentThreatening;
  private double violence;


  public AppUser getAppUser() {
    return appUser;
  }

  public void setAppUser(AppUser appUser) {
    this.appUser = appUser;
  }

  public double getSexual() {
    return sexual;
  }

  public void setSexual(double sexual) {
    this.sexual = sexual;
  }

  public double getHate() {
    return hate;
  }

  public void setHate(double hate) {
    this.hate = hate;
  }

  public double getHarassment() {
    return harassment;
  }

  public void setHarassment(double harassment) {
    this.harassment = harassment;
  }

  public double getSelfHarm() {
    return selfHarm;
  }

  public void setSelfHarm(double selfHarm) {
    this.selfHarm = selfHarm;
  }

  public double getSexualMinors() {
    return sexualMinors;
  }

  public void setSexualMinors(double sexualMinors) {
    this.sexualMinors = sexualMinors;
  }

  public double getHateThreatening() {
    return hateThreatening;
  }

  public void setHateThreatening(double hateThreatening) {
    this.hateThreatening = hateThreatening;
  }

  public double getViolenceGraphic() {
    return violenceGraphic;
  }

  public void setViolenceGraphic(double violenceGraphic) {
    this.violenceGraphic = violenceGraphic;
  }

  public double getSelfHarmIntent() {
    return selfHarmIntent;
  }

  public void setSelfHarmIntent(double selfHarmIntent) {
    this.selfHarmIntent = selfHarmIntent;
  }

  public double getSelfHarmInstructions() {
    return selfHarmInstructions;
  }

  public void setSelfHarmInstructions(double selfHarmInstructions) {
    this.selfHarmInstructions = selfHarmInstructions;
  }

  public double getHarassmentThreatening() {
    return harassmentThreatening;
  }

  public void setHarassmentThreatening(double harassmentThreatening) {
    this.harassmentThreatening = harassmentThreatening;
  }

  public double getViolence() {
    return violence;
  }

  public void setViolence(double violence) {
    this.violence = violence;
  }
}
