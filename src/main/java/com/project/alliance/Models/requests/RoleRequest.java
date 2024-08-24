package com.project.alliance.Models.requests;

import com.project.alliance.Constants.Status;
import com.project.alliance.Models.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequest {

    @NotNull(message = "The role entered cannot be null")
    @NotEmpty(message = "The role entered cannot be empty")
    @Pattern(regexp = "^[A-Z_]+$", message = "Role must contain only capital letters and underscores")
    private String role;
    private Status status;
    private String roleId;

    public Role toRole() throws Exception {
        Role roleRequest = new Role();
        roleRequest.setRole(role);
        if(status == null){
            roleRequest.setStatus(status.NEW.name());
        } else {
            roleRequest.setStatus(status.name());
        }
        roleRequest.setRoleId(roleId);
        return roleRequest;
    }
}
