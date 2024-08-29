package com.project.alliance.Services;

import com.project.alliance.Exceptions.ConflictException;
import com.project.alliance.Interfaces.RolesAndPermissionsService;
import com.project.alliance.Models.RolesAndPermissions;
import com.project.alliance.Models.requests.RolesAndPermissionsRequest;
import com.project.alliance.Models.responses.RolesAndPermissionsResponse;
import com.project.alliance.Repositories.RolesAndPermissionsRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RolesAndPermissionsServiceImpl implements RolesAndPermissionsService {

    private final RolesAndPermissionsRepository rolesAndPermissionsRepository;
    private Logger logger = LogManager.getLogger(RolesAndPermissionsServiceImpl.class);
    @Override
    public List<RolesAndPermissionsResponse> createRolesPermissions(List<RolesAndPermissionsRequest> rolesAndPermissionsRequest) {
        List<RolesAndPermissionsResponse> rolesAndPermissionsResponses = new ArrayList<>();
        for(RolesAndPermissionsRequest roleAndPermissionRequest : rolesAndPermissionsRequest){
            RolesAndPermissions rolesAndPermissionsToSave = roleAndPermissionRequest.toRolesAndPermissions();
            RolesAndPermissions savedRolesAndPermissions = rolesAndPermissionsRepository.findRolesAndPermissionsByRoleIdAndPermissionId(roleAndPermissionRequest.getRoleId(),roleAndPermissionRequest.getPermissionId());
            if(savedRolesAndPermissions != null){
                logger.info("This rolespermission exists already {}",savedRolesAndPermissions);
                throw new ConflictException("The rolespermission already exists");
            }
            savedRolesAndPermissions = rolesAndPermissionsRepository.save(rolesAndPermissionsToSave);
            RolesAndPermissionsResponse rolesAndPermissionsResponse = RolesAndPermissionsResponse.fromSavedRolesAndPermissions(savedRolesAndPermissions);
            rolesAndPermissionsResponses.add(rolesAndPermissionsResponse);
        }
        return rolesAndPermissionsResponses;
    }

    @Override
    public List<RolesAndPermissionsResponse> fetchRolesPermissions() {
        List<RolesAndPermissions> savedRolesAndPermissions = rolesAndPermissionsRepository.findAll();
        return RolesAndPermissionsResponse.fromSavedRolesAndPermissionsList(savedRolesAndPermissions);
    }
}
