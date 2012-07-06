package com.nuaavee.company;

import com.nuaavee.company.employee.Employee;
import com.nuaavee.company.employee.Person;
import java.util.List;

public interface Company {
  String getLocation();

  String getName();

  boolean isIPO();

  Person getOwner();

  List<Employee> getEmployees();
}
