package com.project.alliance.Repositories;

import com.project.alliance.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeByEmail(String email);
    Employee findEmployeeByEmployeeId(String employeeId);

    Employee findEmployeeByUsername(String username);

    List<Employee> findAll();

}
