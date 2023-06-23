package ru.skypro.homework.springsecurity.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.springsecurity.pojo.Employee;
import ru.skypro.homework.springsecurity.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public int getSumEmployeeSalary() {
        return employeeRepository.getSumSalary();
    }
    @Override
    public int getMinEmployeeSalary() {
        return employeeRepository.getMinSalary();
    }
    @Override
    public int getMaxEmployeeSalary() {
        return employeeRepository.getMaxSalary();
    }
    @Override
    public List<Employee> getHighSalaryEmployees() {
        return employeeRepository.getHighSalary();
    }

    @Override
    public List<Employee> getHigherThanSalaryEmployees(Integer salary) {
        return employeeRepository.getHigherThanSalary(salary);
    }

    @Override
    public void updateEmployeeById(Integer id, Employee employee) {
        employeeRepository.updateById(id, employee);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    @Override
    public void addListOfEmployees(List<Employee> employees) {
        employeeRepository.addListOf(employees);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.getById(id);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
