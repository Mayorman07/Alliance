package com.project.alliance.Models.responses;

import com.project.alliance.Models.RolesAndPermissions;
import com.project.alliance.Utils.TimeUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolesAndPermissionsResponse {

    private Long id;
    private String roleId;
    private String permissionId;
    private String status;
    private String createdAt;
    private String updatedAt;

    public static RolesAndPermissionsResponse fromSavedRolesAndPermissions(RolesAndPermissions savedRolesAndPermissions){
        return RolesAndPermissionsResponse
                .builder()
                .id(savedRolesAndPermissions.getId())
                .roleId(savedRolesAndPermissions.getRoleId())
                .permissionId(savedRolesAndPermissions.getPermissionId())
                .status(savedRolesAndPermissions.getStatus())
                .createdAt(TimeUtil.getIsoTime(savedRolesAndPermissions.getCreatedAt()))
                .updatedAt(TimeUtil.getIsoTime(savedRolesAndPermissions.getUpdatedAt()))
                .build();
    }

    public static RolesAndPermissionsResponse fromSavedRoleAndPermissions(
            RolesAndPermissions savedRolesPermission) {
        return RolesAndPermissionsResponse
                .builder()
                .roleId(savedRolesPermission.getRoleId())
                .permissionId(savedRolesPermission.getPermissionId())
                .status(savedRolesPermission.getStatus())
                .createdAt(TimeUtil.getIsoTime(savedRolesPermission.getCreatedAt()))
                .updatedAt(TimeUtil.getIsoTime(savedRolesPermission.getUpdatedAt()))
                .build();
    }

    public static List<RolesAndPermissionsResponse> fromSavedRoleAndPermissions(
            List<RolesAndPermissions> rolesAndPermissions) {
        return rolesAndPermissions.stream()
                .map(
                        rolePermission -> {
                            return fromSavedRoleAndPermissions(rolePermission);
                        })
                .collect(Collectors.toList());
    }
    public static List<RolesAndPermissionsResponse>  fromSavedRolesAndPermissionsList(List<RolesAndPermissions> savedRolesAndPermissions ){
        return savedRolesAndPermissions
                .stream()
                .map(RolesAndPermissionsResponse::fromSavedRolesAndPermissions)
                .collect(Collectors.toList());
    }

    public static RolesAndPermissionsResponse fromNullRolesAndPermissions() {
        return RolesAndPermissionsResponse
                .builder()
                .status("RolePermission Not Found")
                .build();
    }
}
