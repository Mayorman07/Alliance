package com.project.alliance.Repositories;

import com.project.alliance.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByRoleId(String roleId);
    Role findRoleByRole(String roleName);

}
