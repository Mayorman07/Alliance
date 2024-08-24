package com.project.alliance.Models.requests;

import com.project.alliance.Constants.Status;
import com.project.alliance.Models.Employee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    @NotNull(message = "First name cannot be null")
    @NotEmpty(message = "First name cannot be empty")
    private String firstName;
    @NotNull(message = "Last name cannot be null")
    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;
    @NotNull(message = "User name cannot be null")
    @NotEmpty(message = "User name cannot be empty")
    private String username;
    private String password;
    @NotNull(message = "Gender field cannot be null")
    @NotEmpty(message = "Gender field cannot be empty")
    private String gender;
    @Email
    private String email;
    private Status status;
    private boolean enabled;
    private String employeeId;
    private String department;


    public Employee toEmployee(){
        Employee employee = new Employee();
        employee.setGender(gender);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setDepartment(department);
        employee.setEmail(email);
        employee.setEmployeeId(employeeId);
        if(status == null){
            employee.setStatus(status.NEW.name());
        } else{
            employee.setStatus(status.name());
        }
        employee.setPassword(password);
        employee.setGender(gender);
        employee.setUsername(username);
        return employee;

    }



}
