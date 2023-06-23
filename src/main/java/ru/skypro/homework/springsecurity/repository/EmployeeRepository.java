package ru.skypro.homework.springsecurity.repository;

import ru.skypro.homework.springsecurity.pojo.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAllEmployees();
    int getSumSalary();
    int getMinSalary();
    int getMaxSalary();
    List<Employee> getHighSalary();
    List<Employee> getHigherThanSalary(Integer salary);
    void updateById(Integer id, Employee employee);
    void addEmployee(Employee employee);
    void addListOf(List<Employee> employees);
    Employee getById(Integer id);
    void deleteById(Integer id);
}
