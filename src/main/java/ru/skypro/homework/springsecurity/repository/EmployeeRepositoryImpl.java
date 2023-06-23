package ru.skypro.homework.springsecurity.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.homework.springsecurity.pojo.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    // Коллекция для имитации данных
    List<Employee> employeeList = List.of(
            new Employee(0,"Катя", 90_000),
            new Employee(1,"Дима", 102_000),
            new Employee(2,"Олег", 80_000),
            new Employee(3,"Вика", 165_000));

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public int getSumSalary() {
        int sum = 0;
        for(Employee employee: employeeList) {
            sum = sum + employee.getSalary();
        }
        return sum;
    }

    @Override
    public int getMinSalary() {
        int min = employeeList.get(0).getSalary();
        for(int i = 1; i < employeeList.size(); i++) {
            if(employeeList.get(i).getSalary() < min) {
                min = employeeList.get(i).getSalary();
            }
        }
        return min;
    }

    @Override
    public int getMaxSalary() {
        int max = employeeList.get(0).getSalary();
        for(int i = 1; i < employeeList.size(); i++) {
            if(employeeList.get(i).getSalary() > max) {
                max = employeeList.get(i).getSalary();
            }
        }
        return max;
    }

    @Override
    public List<Employee> getHighSalary() {
        int sum = getSumSalary();
        int average = sum / employeeList.size();
        List<Employee> empl = new ArrayList<>();
        for(Employee employee: employeeList) {
            if(employee.getSalary() > average) {
                empl.add(employee);
            }
        }
        return empl;
    }

    @Override
    public List<Employee> getHigherThanSalary(Integer salary) {
        List<Employee> emplList = new ArrayList<>();
        for(Employee employee: employeeList) {
            if (employee.getSalary() > salary) {
                emplList.add(employee);
            }
        }
        return emplList;
    }

    @Override
    public void updateById(Integer id, Employee employee) {
        for(int i=0; i<employeeList.size(); i++){
            if(employeeList.get(i).getId() == id){
                employeeList.get(id).setName(employee.getName());
                employeeList.get(id).setSalary(employee.getSalary());
            }
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        //System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getSalary());
        //System.out.println(employeeList.size());
        List<Employee> e = new ArrayList<>(employeeList);
        //System.out.println(e.size());
        e.add(employee);
        //System.out.println(e.size());
        setEmployeeList(e);
        //System.out.println(employeeList.size());
    }

    @Override
    public void addListOf(List<Employee> employees) {
        List<Employee> arrayList = new ArrayList<>(employeeList);
        arrayList.addAll(employees);
        setEmployeeList(arrayList);
        //for(Employee e: employeeList) {
        //    System.out.println(e.getName()+" "+e.getId());
        //}
    }

    @Override
    public Employee getById(Integer id) {
        int index = -1;
        for(int i=0; i<employeeList.size(); i++) {
            if(employeeList.get(i).getId() == id) {
                index = i;
            }
        }
        //System.out.println(employeeList.get(index).getName());
        return employeeList.get(index);
    }

    @Override
    public void deleteById(Integer id) {
        //System.out.println(id);
        //for(Employee e: employeeList) {
        //    System.out.println(e.getName()+" "+e.getId());
        //}
        List<Employee> arrayList = new ArrayList<>(employeeList);
        for(int i=0; i<arrayList.size(); i++){
            if(arrayList.get(i).getId() == id) {
                arrayList.remove(i);
                i--;
            }
        }
        setEmployeeList(arrayList);
        //for(Employee e: employeeList) {
        //    System.out.println(e.getName()+" "+e.getId());
        //}
    }
}
