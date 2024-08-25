package com.project.alliance.Repositories;

import com.project.alliance.Models.RolesAndPermissions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolesAndPermissionsRepository extends JpaRepository<RolesAndPermissions, Long> {

    RolesAndPermissions findRolesAndPermissionsByRoleIdAndPermissionId(String roleId,String permissionId);
    RolesAndPermissions findRolesAndPermissionsById(Long id);
    List<RolesAndPermissions> findByRoleId(String roleId);
}
