package com.example.sample.map_example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Create departments
        Department dept1 = new Department("HR");
        Department dept2 = new Department("Engineering");
        Department dept3 = new Department("Marketing");

        // Create employees
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", dept1),
            new Employee("Bob", dept2),
            new Employee("Charlie", dept2),
            new Employee("Diana", dept3),
            new Employee("Eve", dept1)
        );

        // Group employees by department
        Map<Department, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // Print the grouped map
        byDept.forEach((department, employeeList) -> {
            System.out.println(department.getName() + ": " + employeeList);
        });
    }
}
