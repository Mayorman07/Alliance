package com.project.alliance.Models.requests;

import com.project.alliance.Constants.Status;
import com.project.alliance.Models.Permission;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionRequest {

    @NotBlank(message = "Name cannot be blank")
    @Pattern(regexp = "^[A-Z_]+$", message = "Name must consist of capital letters and underscores only")
    private String name;
    @NotBlank(message = "Action cannot be blank")
    private String action;
    private Status status;
    private String permissionId;

    public Permission toPermissions() throws Exception {
        Permission permissionRequest = new Permission();
        permissionRequest.setName(name);
        permissionRequest.setAction(action);
        if(status == null){
            permissionRequest.setStatus(status.NEW.name());
        } else {
            permissionRequest.setStatus(status.name());
        }
        permissionRequest.setPermissionId(permissionId);
        return permissionRequest;
    }
}
