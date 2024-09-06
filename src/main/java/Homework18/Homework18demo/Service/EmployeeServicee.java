package Homework18.Homework18demo.Service;

import Homework18.Homework18demo.model.Employee;

import java.util.Collection;

public interface EmployeeServicee {
    void addEmployee(String firstName, String lastName, int salary, int deport);

    void removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> getAll();
}

