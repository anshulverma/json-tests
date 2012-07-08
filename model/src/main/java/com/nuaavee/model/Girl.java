package com.nuaavee.model;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Girl extends Person {

  @SuppressWarnings("unused")
  @JsonIgnore
  private int age;

  public Girl() {
    this(0, "", "");
  }

  public Girl(int age, String firstName, String lastName) {
    super(age, new Name(firstName, lastName));
  }

}