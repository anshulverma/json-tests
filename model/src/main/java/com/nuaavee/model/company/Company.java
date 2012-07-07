package com.nuaavee.model.company;

import com.nuaavee.model.company.employee.Employee;
import com.nuaavee.model.company.employee.Person;

import java.util.List;

public interface Company {
  String getLocation();

  String getName();

  boolean isIPO();

  Person getOwner();

  List<Employee> getEmployees();
}
