package com.shabir.problemsolving.random;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class EmployeeUtils {

  public static void main(String[] args) {
    Employee emp1 = new Employee(1, 2);
    Employee emp2 = new Employee(5, -3);
    //Employee emp3 = new Employee(3, 3);
    emp1.linkSubordinate(emp2);
    //emp2.linkSubordinate(emp3);

    Map<Integer, Employee> employeeDataMap = new HashMap<>();
    employeeDataMap.put(emp1.getEmployeeId(), emp1);
    employeeDataMap.put(emp2.getEmployeeId(), emp2);
    //employeeDataMap.put(emp3.getEmployeeId(), emp3);

    Integer result = findEmployeeTotalImportanceValue(employeeDataMap, 5);
    if (Objects.isNull(result)) {
      System.out.println("Employee not found");
    }
    System.out.println("Result = " + result);
  }

  private static Integer findEmployeeTotalImportanceValue(
      Map<Integer, Employee> employeeDataMap, int employeeId) {

    if (!employeeDataMap.containsKey(employeeId)) {
      System.out.println("Employee Id " + employeeId + " does not exist");
      return null;
    }

    Employee desiredEmployee = employeeDataMap.get(employeeId);
    int totalImportanceValue = findEmployeeTotalImportanceValue(desiredEmployee);
    return totalImportanceValue;
  }

  private static int findEmployeeTotalImportanceValue(Employee employee) {
    int totalImportanceValue = employee.getImportanceValue();
    List<Employee> subordinateEmployees = employee.getSubordinateEmployees();
    if (Objects.nonNull(subordinateEmployees) && !subordinateEmployees.isEmpty()) {
      for (Employee subordinateEmployee : subordinateEmployees) {
        totalImportanceValue += findEmployeeTotalImportanceValue(subordinateEmployee);
      }
    }
    return totalImportanceValue;
  }

}
