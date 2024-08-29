package com.project.alliance.Models.responses;

import com.project.alliance.Models.Employee;
import com.project.alliance.Utils.TimeUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String status;
    private String role;
    private boolean enabled;
    private String employeeId;
    private String username;
    private Date lastLoggedIn;
    private String createdAt;
    private String updatedAt;


    public static EmployeeResponse fromExistingEmployee(Employee existingEmployee) {
        return EmployeeResponse.builder()
                .firstName(existingEmployee.getFirstName())
                .lastName(existingEmployee.getLastName())
                .username(existingEmployee.getUsername())
                .status(existingEmployee.getStatus())
                .lastLoggedIn(existingEmployee.getLastLoggedIn())
                .email(existingEmployee.getEmail())
                .employeeId(existingEmployee.getEmployeeId())
                .createdAt(TimeUtil.getIsoTime(existingEmployee.getCreatedAt()))
                .updatedAt(TimeUtil.getIsoTime(existingEmployee.getUpdatedAt()))
                .build();
    }
    public static List<EmployeeResponse> fromExistingEmployees(List<Employee> savedEmployees){
        return savedEmployees
                .stream()
                .map(EmployeeResponse::fromExistingEmployee)
                .collect(Collectors.toList());
    }

}
