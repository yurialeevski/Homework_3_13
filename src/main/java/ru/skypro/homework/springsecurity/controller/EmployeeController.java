package ru.skypro.homework.springsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.springsecurity.pojo.Employee;
import ru.skypro.homework.springsecurity.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /*@PutMapping("/{id}")
    public void updateEmployeeById(@PathVariable Integer id, @RequestBody Employee employee) {
        employeeService.updateEmployeeById(id, employee);
    }*/
    /*@PostMapping("/single-employee")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }*/
    /*@PostMapping("/")
    public void addListOfEmployees(@RequestBody List<Employee> employees){
        employeeService.addListOfEmployees(employees);
    }*/

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }
    /*@DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
    }*/
    @GetMapping("/salaryHigherThan")
    public List<Employee> showSalaryHigherThan(@RequestParam("salary") Integer salary) {
        return employeeService.getHigherThanSalaryEmployees(salary);
    }
    @GetMapping("/all-employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/salary/sum")
    public int showSumEmployeeSalary() {
        return employeeService.getSumEmployeeSalary();
    }
    @GetMapping("/salary/min")
    public int showMinEmployeeSalary() {
        return employeeService.getMinEmployeeSalary();
    }
    @GetMapping("/salary/max")
    public int showMaxEmployeeSalary() { return employeeService.getMaxEmployeeSalary();}
    @GetMapping("/high-salary")
    public List<Employee> showHighSalaryEmployees() { return employeeService.getHighSalaryEmployees();}
}
