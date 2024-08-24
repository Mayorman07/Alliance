package com.project.alliance.Interfaces;

import com.project.alliance.Models.requests.RoleRequest;
import com.project.alliance.Models.responses.RoleResponse;

import java.util.List;

public interface RoleService {
    List<RoleResponse> createRole(List<RoleRequest> roleRequest) throws Exception;
    RoleResponse findRoleByRoleId(String roleId);
    List<RoleResponse> fetchRoles();
}
