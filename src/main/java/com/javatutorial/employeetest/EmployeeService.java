package com.javatutorial.employeetest;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Service
public class EmployeeService implements EmployeeServiceInterface {
    private final int capacity = 10;
    private final List<Employee> employees = new ArrayList<>(capacity);
    private int size = 0;

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (size == capacity) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        size++;
        return employee;
    }

    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        size--;
        return employee;
    }

    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Collection<Employee> getEmployeeList() {
        return Collections.unmodifiableList(employees);
    }

}
