package com.project.alliance.Controllers;

import com.project.alliance.Interfaces.EmployeeService;
import com.project.alliance.Models.requests.EmployeeRequest;
import com.project.alliance.Models.responses.EmployeeResponse;
import com.project.alliance.Validations.InputValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RequestMapping(value = "api/employees")
@RequiredArgsConstructor
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;
 @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeResponse> createEmployee(@Valid @RequestBody List<EmployeeRequest> employeeRequest, BindingResult bindingResult){
        InputValidator.validate(bindingResult);
     log.info("The create employee  request {}", employeeRequest);
        List<EmployeeResponse> employeeResponse = employeeService.createEmployee(employeeRequest);
     log.info("The create employee response {}", employeeResponse);
        return employeeResponse;
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeResponse> updateEmployee (@RequestBody List<EmployeeRequest> employeeRequest){
        log.info("The update employee request {}", employeeRequest);
     List<EmployeeResponse> employeeResponse = employeeService.updateEmployee(employeeRequest);
        log.info("The update employee response {}", employeeResponse);
     return employeeResponse;
       }

    @GetMapping(path = "/employeeId/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeResponse getEmployeeByEmployeeId(@PathVariable("employeeId") String employeeId){
        log.info("The get employee by Id request {}", employeeId);
        EmployeeResponse employeeResponse = employeeService.getEmployeeByEmployeeId(employeeId);
        log.info("update employee response {}", employeeResponse);
        return employeeResponse;
    }

    @GetMapping(path = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeResponse> fetchUsers(){
        log.info("fetch employees");
        List<EmployeeResponse> employeeResponse = employeeService.fetchEmployees();
        log.info("fetch employes response {}", employeeResponse);
        return employeeResponse;
    }
    @DeleteMapping(path = "/employeeId/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeResponse deleteEmployeeByEmployeeId(@PathVariable("employeeId") String employeeId){
        log.info("Delete user request for User ID: {}", employeeId);
        EmployeeResponse employeeResponse = employeeService.deleteEmployeeByEmployeeId(employeeId);
        log.info("Deleted user response: {}", employeeResponse);
        return employeeResponse;
    }

}



