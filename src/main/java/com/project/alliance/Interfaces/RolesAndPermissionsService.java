package com.project.alliance.Interfaces;

import com.project.alliance.Models.requests.RolesAndPermissionsRequest;
import com.project.alliance.Models.responses.RolesAndPermissionsResponse;

import java.util.List;

public interface RolesAndPermissionsService {

    List<RolesAndPermissionsResponse> createRolesPermissions(List<RolesAndPermissionsRequest> rolesAndPermissionsRequest) throws Exception;

//    RolesAndPermissionsResponse updateRolesPermissions(RolesAndPermissionsRequest rolesAndPermissionsRequest) throws Exception;
//
//    List<RolesAndPermissionsResponse> getRolesPermissions(String roleId);

    List<RolesAndPermissionsResponse> fetchRolesPermissions();
}
