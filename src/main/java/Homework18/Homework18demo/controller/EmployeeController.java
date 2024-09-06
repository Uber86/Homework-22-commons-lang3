package Homework18.Homework18demo.controller;

import Homework18.Homework18demo.model.Employee;
import Homework18.Homework18demo.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService service;


    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping(path = "/add")
    public void addEmployee(@RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam int salary,
                            @RequestParam int deport) {
        service.validate(firstName,lastName);
        service.addEmployee(firstName, lastName, salary, deport);
    }

    @GetMapping(path = "/remove")
    public void removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        service.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/all")
    public Collection<Employee> getAll() {
        return service.getAll();

    }




}
