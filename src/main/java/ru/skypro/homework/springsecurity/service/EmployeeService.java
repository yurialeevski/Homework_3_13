package ru.skypro.homework.springsecurity.service;

import ru.skypro.homework.springsecurity.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    int getSumEmployeeSalary();
    int getMinEmployeeSalary();
    int getMaxEmployeeSalary();
    List<Employee> getHighSalaryEmployees();
    List<Employee> getHigherThanSalaryEmployees(Integer salary);
    void updateEmployeeById(Integer id, Employee employee);
    void addEmployee(Employee employee);
    void addListOfEmployees(List<Employee> employees);
    Employee getEmployeeById(Integer id);
    void deleteEmployeeById(Integer id);
}
