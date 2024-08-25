package com.project.alliance.Controllers;

import com.project.alliance.Interfaces.RolesAndPermissionsService;
import com.project.alliance.Models.requests.RolesAndPermissionsRequest;
import com.project.alliance.Models.responses.RolesAndPermissionsResponse;
import com.project.alliance.Validations.InputValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/rolepermissions")
public class RolesAndPermissionsController {

    private final RolesAndPermissionsService rolesPermissionsService;
    private final Logger logger = LogManager.getLogger(RolesAndPermissionsController.class);

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RolesAndPermissionsResponse> createRolesPermissions(@Valid @RequestBody List<RolesAndPermissionsRequest> rolesAndPermissionsRequest,
                                                                    BindingResult bindingResult) throws Exception {
        logger.info("Create roles permissions request: {}", rolesAndPermissionsRequest);
        InputValidator.validate(bindingResult);
        List<RolesAndPermissionsResponse> rolesPermissionsResponse = rolesPermissionsService.createRolesPermissions(rolesAndPermissionsRequest);
        logger.info("Create roles permissions response: {}", rolesPermissionsResponse);
        return rolesPermissionsResponse;
    }

    @GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RolesAndPermissionsResponse> fetchRolesPermissions() {
        logger.info("Fetch roles permissions request");
        List<RolesAndPermissionsResponse> rolesPermissionsResponses = rolesPermissionsService.fetchRolesPermissions();
        logger.info("Fetch roles permissions response: {}", rolesPermissionsResponses);
        return rolesPermissionsResponses;
    }
}
