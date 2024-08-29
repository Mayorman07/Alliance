<<<<<<< HEAD
package com.project.alliance.Interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.alliance.Models.requests.PermissionRequest;
import com.project.alliance.Models.responses.PermissionResponse;

import java.util.List;

public interface PermissionsService {

    List<PermissionResponse> createPermission(List<PermissionRequest> permissionsRequest) throws Exception;
    PermissionResponse findByPermissionId(String roleId) throws JsonProcessingException;
//    PermissionResponse getPermission(String permissionId);
    List<PermissionResponse> fetchPermissions();
}
=======
package com.project.alliance.Interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.alliance.Models.requests.PermissionRequest;
import com.project.alliance.Models.responses.PermissionResponse;

import java.util.List;

public interface PermissionsService {

    List<PermissionResponse> createPermission(List<PermissionRequest> permissionsRequest) throws Exception;
//    PermissionResponse findByPermissionId(String roleId) throws JsonProcessingException;
//    PermissionResponse getPermission(String permissionId);
    List<PermissionResponse> fetchPermissions();
}
>>>>>>> e0589cf7366caabbb3463afb18dbcfb834fb30b9
