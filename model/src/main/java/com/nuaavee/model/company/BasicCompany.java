package com.nuaavee.model.company;

import com.nuaavee.model.Person;
import com.nuaavee.model.company.employee.Employee;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import java.util.Collections;
import java.util.List;

public class BasicCompany implements Company {
  String location;
  String name;
  boolean ipo;
  Person owner;
  List<Employee> employees;

  public BasicCompany() {
    this("", "", false, new Person(), Collections.<Employee> emptyList());
  }

  public BasicCompany(String location, String name, boolean ipo, Person owner,
      List<Employee> employees) {
    super();
    this.location = location;
    this.name = name;
    this.ipo = ipo;
    this.owner = owner;
    this.employees = employees;
  }

  @Override
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean isIPO() {
    return ipo;
  }

  public void setIPO(boolean ipo) {
    this.ipo = ipo;
  }

  @Override
  public Person getOwner() {
    return owner;
  }

  public void setOwner(Person owner) {
    this.owner = owner;
  }

  @Override
  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this,
        ToStringStyle.SHORT_PREFIX_STYLE);
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
      .append(location)
      .append(name)
      .append(ipo)
      .append(owner)
      .append(employees)
      .toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof BasicCompany)) {
      return false;
    }

    BasicCompany other = (BasicCompany) obj;
    return new EqualsBuilder()
      .append(other.location, location)
      .append(other.name, name)
      .append(other.ipo, ipo)
      .append(other.owner, owner)
      .append(other.employees, employees)
      .isEquals();
  }
}
