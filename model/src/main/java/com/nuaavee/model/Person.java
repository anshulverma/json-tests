package com.nuaavee.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonProperty;

public class Person {
  private int age;
  private Name name;

  public Person() {
    this(0, new Name());
  }

  public Person(int age, Name name) {
    super();
    this.age = age;
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @JsonProperty("jcr:title")
  public Name getJcrTitle() {
    return name;
  }

  @JsonProperty("jcr:title")
  public void setJcrTitle(Name jcrTitle) {
    this.name = jcrTitle;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this,
        ToStringStyle.SHORT_PREFIX_STYLE);
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
      .append(age)
      .append(name)
      .toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof Person)) {
      return false;
    }

    Person other = (Person) obj;
    return new EqualsBuilder()
      .append(other.age, age)
      .append(other.name, name)
      .isEquals();
  }
}
