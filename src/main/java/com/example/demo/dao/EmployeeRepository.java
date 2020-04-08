package com.example.demo.dao;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository <Employee, Long> {

    // Wprowadzenie do repozytorium kolekcji oraz metody pozwalającej na refleksję
    //Iterable<Employee> findByFirstName(String firstName);

    @Query("SELECT e FROM Employee e where e.lastName LIKE %?1")
    Iterable<Employee> findAllWhereName(String lastName);
}
