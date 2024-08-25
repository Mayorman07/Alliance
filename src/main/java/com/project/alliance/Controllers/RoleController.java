package com.project.alliance.Controllers;

import com.project.alliance.Interfaces.RoleService;
import com.project.alliance.Models.requests.RoleRequest;
import com.project.alliance.Models.responses.RoleResponse;
import com.project.alliance.Validations.InputValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/roles")
public class RoleController {

    private final RoleService rolesService;
    private final Logger logger = LogManager.getLogger(RoleController.class);

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RoleResponse> createRole(@Valid @RequestBody List<RoleRequest> roleRequest,
                                         BindingResult bindingResult) throws Exception {
        logger.info("Create role request: {}", roleRequest);
        InputValidator.validate(bindingResult);
        logger.info("Create role request Teo: {}", roleRequest);
        List<RoleResponse> rolesResponse = rolesService.createRole(roleRequest);
        logger.info("Create role response: {}", rolesResponse);
        return rolesResponse;
    }

    @GetMapping(path = "/roleId/{roleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RoleResponse findRoleByRoleId(@PathVariable("roleId") String roleId) {
        logger.info("Find role by roleId request: {}", roleId);
        RoleResponse rolesResponse = rolesService.findRoleByRoleId(roleId);
        logger.info("Find role by roleId response: {}", rolesResponse);
        return rolesResponse;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RoleResponse> fetchRoles() {
        logger.info("Fetch roles");
        List<RoleResponse> rolesResponse = rolesService.fetchRoles();
        logger.info("Fetch roles response: {}", rolesResponse);
        return rolesResponse;
    }

}
