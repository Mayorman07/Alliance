package com.project.alliance.Models.requests;

import com.project.alliance.Constants.Status;
import com.project.alliance.Models.RolesAndPermissions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolesAndPermissionsRequest {

    private Long id;
    private String roleId;
    private String permissionId;
    private Status status;

    public RolesAndPermissions toRolesAndPermissions() {
        RolesAndPermissions rolesPermissionsRequest = new RolesAndPermissions();
        rolesPermissionsRequest.setId(id);
        rolesPermissionsRequest.setRoleId(roleId);
        rolesPermissionsRequest.setPermissionId(permissionId);
        if(status == null){
            rolesPermissionsRequest.setStatus(status.ACTIVE.name());
        } else {
            rolesPermissionsRequest.setStatus(status.name());
        }
        return rolesPermissionsRequest;
    }
}
