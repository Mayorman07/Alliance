package com.project.alliance.Controllers;

import com.project.alliance.Interfaces.PermissionsService;
import com.project.alliance.Models.requests.PermissionRequest;
import com.project.alliance.Models.responses.PermissionResponse;
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
@RequestMapping(value = "/api/permissions")
public class PermissionController {

    private final PermissionsService permissionService;
    private final Logger logger = LogManager.getLogger(PermissionController.class);

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PermissionResponse> createPermission(@Valid @RequestBody List<PermissionRequest> permissionsRequest,
                                                     BindingResult bindingResult) throws Exception {
        logger.info("Create permission request: {}", permissionsRequest);
        InputValidator.validate(bindingResult);
        List<PermissionResponse> permissionsResponse = permissionService.createPermission(permissionsRequest);
        logger.info("Create permission response: {}", permissionsResponse);
        return permissionsResponse;
    }

    @GetMapping(path ="/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PermissionResponse> fetchPermissions() {
        logger.info("Fetch permissions request");
        List<PermissionResponse> permissionsResponses = permissionService.fetchPermissions();
        logger.info("Fetch permissions response: {}", permissionsResponses);
        return permissionsResponses;
    }
}
