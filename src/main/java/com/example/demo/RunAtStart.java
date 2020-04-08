package com.example.demo;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class RunAtStart {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public RunAtStart(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    public void runAtStart() {

        Employee employee = new Employee();
        employee.setFirstName("Jan");
        employee.setLastName("Kowalski");
        employee.setSalary(new BigDecimal("3000.00"));
        employeeRepository.save(employee);

        Employee employee1 = new Employee();
        employee1.setFirstName("Jan");
        employee1.setLastName("Nowak");
        employee1.setSalary(new BigDecimal("3500.00"));
        employeeRepository.save(employee1);

        // wykorzystanie specyfikacji kolekcji przy wyszukiwaniu pracowników
        //Iterable<Employee> jans = employeeRepository.findByFirstName("Jan");
        /*Employee jan = jans.iterator().next();
        System.out.println("Janek: " + jan);*/

        /*for (Employee e:jans) {
            System.out.println("Janek: " + e);
        }*/

        Iterable<Employee> em = employeeRepository.findAllWhereName("K%");
        for (Employee e:em) {
            System.out.println(e);
        }
    }
}
