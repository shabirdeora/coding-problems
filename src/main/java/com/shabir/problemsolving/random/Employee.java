package com.shabir.problemsolving.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {

  private int employeeId;
  private int importanceValue;
  private List<Employee> subordinateEmployees;

  public Employee(int employeeId, int importanceValue) {
    this.employeeId = employeeId;
    this.importanceValue = importanceValue;
  }

  public void linkSubordinate(Employee employee) {
    if (Objects.isNull(subordinateEmployees)) {
      subordinateEmployees = new ArrayList<>();
    }
    subordinateEmployees.add(employee);
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public int getImportanceValue() {
    return importanceValue;
  }

  public List<Employee> getSubordinateEmployees() {
    return subordinateEmployees;
  }
}
