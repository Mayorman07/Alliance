package com.project.alliance.Services;

import com.project.alliance.Exceptions.ConflictException;
import com.project.alliance.Exceptions.NotFoundException;
import com.project.alliance.Utils.EmployeeManagementBeanUtil;
import lombok.extern.slf4j.Slf4j;
import com.project.alliance.Interfaces.EmployeeService;
import com.project.alliance.Models.Employee;
import com.project.alliance.Models.requests.EmployeeRequest;
import com.project.alliance.Models.responses.EmployeeResponse;
import com.project.alliance.Repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private  final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeResponse> createEmployee(List<EmployeeRequest> employeeRequest) {
        List<EmployeeResponse> employeeResponse = new ArrayList<>();

        for(EmployeeRequest initialemployeeRequest : employeeRequest) {
            Employee employeeToSave = initialemployeeRequest.toEmployee();
            Employee existingEmployee = employeeRepository.findEmployeeByUsername(initialemployeeRequest.getUsername());
            if (existingEmployee != null) {
                log.info("This employee exists!");
                throw new ConflictException("Existing employee!");

            }
//            encodePassword(employeeToSave);

            existingEmployee = employeeRepository.save(employeeToSave);
            EmployeeResponse returnedEmployeeResponse = EmployeeResponse.fromExistingEmployee(existingEmployee);
            log.info("The existing employee response {}", existingEmployee);
            employeeResponse.add(returnedEmployeeResponse);
        }
        return employeeResponse;
    }


//    public PasswordEncoder encodeBCrypt() {
//        return new BCryptPasswordEncoder();
//    }

//    private void encodePassword(Employee employeeToSave){
//        String encodedPassword = encodeBCrypt().encode(employeeToSave.getPassword());
//        employeeToSave.setPassword(encodedPassword);
//    }

    @Override
    public List<EmployeeResponse> updateEmployee(List<EmployeeRequest> employeeRequest) {
        List<EmployeeResponse> employeeResponse = new ArrayList<>();
        for(EmployeeRequest initialemployeeRequest : employeeRequest) {
            Employee employeeToUpdate = initialemployeeRequest.toEmployee();
            Employee existingEmployee = employeeRepository.findEmployeeByUsername(initialemployeeRequest.getUsername());
            if (existingEmployee == null) {
                log.info("This employee cannot be found !");
                throw new NotFoundException("Employee does not exist!");
            }
            EmployeeManagementBeanUtil.copyProperties(employeeToUpdate, existingEmployee);
            employeeToUpdate = employeeRepository.save(existingEmployee);
            EmployeeResponse updatedEmployeeResponse = EmployeeResponse.fromExistingEmployee(employeeToUpdate);
            employeeResponse.add(updatedEmployeeResponse);
        }
            return employeeResponse;
    }

    @Override
    public EmployeeResponse getEmployeeByEmployeeId(String employeeId) {
        Employee existingEmployee = employeeRepository.findEmployeeByEmployeeId(employeeId);
        if(existingEmployee == null){
            log.info("This employee cannot be found!");
            throw new NotFoundException("Existing employee not found!");
        }
        log.info("fetched employee by employeeId {}" ,existingEmployee);
        return EmployeeResponse.fromExistingEmployee(existingEmployee);
    }

    @Override
    public EmployeeResponse deleteEmployeeByEmployeeId(String employeeId) {
        Employee existingEmployee = employeeRepository.findEmployeeByEmployeeId(employeeId);
        if(existingEmployee == null){
            log.info("This employee cannot be found!");
            throw new NotFoundException("Existing employee not found!");
        }
        employeeRepository.delete(existingEmployee);
        log.info("Employee has been deleted");
        return EmployeeResponse.fromExistingEmployee(existingEmployee);
    }

    @Override
    public List<EmployeeResponse> fetchEmployees() {
        List<Employee> existingEmployees = employeeRepository.findAll();
        return EmployeeResponse.fromExistingEmployees(existingEmployees);
    }

}
