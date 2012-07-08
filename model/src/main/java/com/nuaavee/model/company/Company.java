package com.nuaavee.model.company;

import java.util.List;
import com.nuaavee.model.Person;
import com.nuaavee.model.company.employee.Employee;

public interface Company {
  String getLocation();

  String getName();

  boolean isIPO();

  Person getOwner();

  List<Employee> getEmployees();
}
