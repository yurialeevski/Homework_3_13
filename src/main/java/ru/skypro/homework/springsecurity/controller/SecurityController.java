package ru.skypro.homework.springsecurity.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.springsecurity.pojo.Employee;
import ru.skypro.homework.springsecurity.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class SecurityController {
    private final EmployeeService employeeService;

    public SecurityController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @DeleteMapping("/admin/{id}")
    public void deleteEmployeeById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
    }

    @PostMapping("/admin/single-employee")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @PutMapping("/admin/{id}")
    public void updateEmployeeById(@PathVariable Integer id, @RequestBody Employee employee) {
        employeeService.updateEmployeeById(id, employee);
    }
}
