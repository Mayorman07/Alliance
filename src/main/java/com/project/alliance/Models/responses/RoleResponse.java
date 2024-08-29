package com.project.alliance.Models.responses;

import com.project.alliance.Models.Role;
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
public class RoleResponse {

    private String role;
    private String roleId;
    private String status;

    public static RoleResponse fromRole(Role role) {
        return RoleResponse
                .builder()
                .roleId(String.valueOf(role.getId()))
                .role(role.getRole())
                .status(role.getStatus())
                .roleId(role.getRoleId())
                .build();
    }

    public static List<RoleResponse> fromRoles(List<Role> roles) {
        return roles
                .stream()
                .map(RoleResponse::fromRole)
                .collect(Collectors.toList());
    }
}
