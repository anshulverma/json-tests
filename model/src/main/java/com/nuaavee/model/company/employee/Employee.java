package com.nuaavee.model.company.employee;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Employee extends Person {
  private double salary;

  public Employee() {
    this(new Name(), 0, 0);
  }

  public Employee(Name name, int age, double salary) {
    super(age, name);
    this.salary = salary;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this,
        ToStringStyle.SHORT_PREFIX_STYLE);
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
      .appendSuper(super.hashCode())
      .append(salary)
      .toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof Employee)) {
      return false;
    }

    Employee other = (Employee) obj;
    return new EqualsBuilder()
      .appendSuper(super.equals(obj))
      .append(other.salary, salary)
      .isEquals();
  }
}
