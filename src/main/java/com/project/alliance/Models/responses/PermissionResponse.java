package com.project.alliance.Models.responses;

import com.project.alliance.Models.Permission;
import com.project.alliance.Utils.TimeUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionResponse {

    private Long id;
    private String name;
    private String action;
    private String status;
    private String permissionId;

    public static PermissionResponse fromPermissions(Permission permissions) {
        return PermissionResponse.builder()
                .id(permissions.getId())
                .name(permissions.getName())
                .action(permissions.getAction())
                .status(permissions.getStatus())
                .permissionId(permissions.getPermissionId())
                .build();
    }

    public static List<PermissionResponse> fromPermissionsList(List<Permission> permissionsList) {
        return permissionsList.stream()
                .map(PermissionResponse::fromPermissions)
                .collect(Collectors.toList());
    }

    public static PermissionResponse fromNullPermissions() {
        return PermissionResponse
                .builder()
                .status("Permission Not Found")
                .build();
    }
}
