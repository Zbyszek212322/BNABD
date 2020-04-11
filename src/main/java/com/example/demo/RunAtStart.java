package com.example.demo;

import com.example.demo.dao.DepartmentRepository;
import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;

@Component
public class RunAtStart {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void runAtStart() {

        // Tworzenie działów
        Department dept1 = departmentRepository.save(new Department("Finances"));
        Department dept2 = departmentRepository.save(new Department("Production"));
        Department dept3 = departmentRepository.save(new Department("To be deleted"));

        // Tworzenie pracowników
        Employee emp1 = employeeRepository.save(new Employee("Jan", "Nowak",
                new BigDecimal(3000.00), dept1));
        Employee emp2 = employeeRepository.save(new Employee("Jan", "Kowalski",
                new BigDecimal(3500.00), dept2));
        Employee emp3 = employeeRepository.save(new Employee("Adam", "Wiśniewski",
                new BigDecimal(3200.00), dept2));
        Employee emp4 = employeeRepository.save(new Employee("Anna", "Wójcik",
                new BigDecimal(2500.00), dept2));

        // Prezentowanie pracowników danego działu podanego jako parametr
        String departmentName = "Production";

        List<Employee> deptName = employeeRepository.findByDepartment(departmentRepository.findByDepartmentName(departmentName));
        for (Employee e:deptName) {
            System.out.println(departmentName + " Department's staff: " + e);
        }

        // Usuwanie pracowników i działów
        employeeRepository.deleteById(4L);
        departmentRepository.deleteById(3L);

        // Modyfikacja wypłaty pracownika
        employeeRepository.save(new Employee(3L,"Adam", "Wiśniewski",
                new BigDecimal(4000.00), dept2));

        //Modyfikacja nazwy działu
        departmentRepository.save(new Department(2L, "Sales"));

        // Prezentowanie pracowników danego działu podanego jako parametr po wcześniejszych modyfikacjach
        departmentName = "Sales";

        List<Employee> deptName1 = employeeRepository.findByDepartment(departmentRepository.findByDepartmentName(departmentName));
        for (Employee e:deptName1) {
            System.out.println(departmentName + " Department's staff: " + e);
        }
    }
}
