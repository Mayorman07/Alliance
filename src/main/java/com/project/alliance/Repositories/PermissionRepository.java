package com.project.alliance.Repositories;

import com.project.alliance.Models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Permission findPermissionByName(String name);
    Permission findPermissionByPermissionId(String permissionId);
}
