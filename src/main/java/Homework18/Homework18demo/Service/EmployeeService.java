package Homework18.Homework18demo.Service;

import Homework18.Homework18demo.exeption.EmployeeAlreadyAddedException;
import Homework18.Homework18demo.exeption.EmployeeNotFoundException;
import Homework18.Homework18demo.exeption.EmployeeStorageIsFullException;
import Homework18.Homework18demo.exeption.ValidateExeption;
import Homework18.Homework18demo.model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServicee{
    private static final int maxEmployee = 10;

    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Liza",
                    "Fedorovna",
                    10000,
                    1),
            new Employee("Lina",
                    "limbovsky",
                    20000,
                    1),
            new Employee("Luna",
                    "Savech",
                    775130,
                    2),
            new Employee("Kolya",
                    "Zamanuhovich",
                    211100,
                    2),
            new Employee("Aly",
                    "Muhhamad",
                    99999999,
                    3),
            new Employee("Zina",
                    "Zvereva",
                    44543500,
                    3)
    ));


    @Override
    public void addEmployee(String firstName, String lastName, int salary, int deport) {
        Employee employee = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), salary, deport);
        if (employees.size() > maxEmployee) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                employees.remove(employee);
                return;
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
            throw new EmployeeNotFoundException();
        }
        return null;
    }
    @Override
    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees);
    }


    void validate(String... values) {
        for (String value : values) {
            if (!StringUtils.isAlpha(value)) {
                throw new ValidateExeption();
            }
        }
    }


}
