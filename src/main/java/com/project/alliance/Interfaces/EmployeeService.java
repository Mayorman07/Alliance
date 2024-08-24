package com.project.alliance.Interfaces;

import com.project.alliance.Models.requests.EmployeeRequest;
import com.project.alliance.Models.responses.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeResponse> createEmployee(List<EmployeeRequest> employeeRequest);
    public List<EmployeeResponse> updateEmployee(List<EmployeeRequest> employeeRequest);
    public EmployeeResponse getEmployeeByEmployeeId (String employeeId);

    public EmployeeResponse deleteEmployeeByEmployeeId (String employeeId);

    public List<EmployeeResponse> fetchEmployees();

}
