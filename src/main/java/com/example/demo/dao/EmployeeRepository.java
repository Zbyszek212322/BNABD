package com.example.demo.dao;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByDepartment(Department department);
}
