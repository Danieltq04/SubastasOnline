package com.examplespring.pruebamvc.model;

public class Applicant {

  private long id;
  private String content;

  public Applicant(String content) {
    this.content = content;
  }
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}