package com.example.demo.dao;

import com.example.demo.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

    Department findByDepartmentName(String departmentName);
}
