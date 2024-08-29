package com.project.alliance.Services;

import com.project.alliance.Exceptions.ConflictException;
import com.project.alliance.Exceptions.NotFoundException;
import com.project.alliance.Interfaces.RoleService;
import com.project.alliance.Models.Role;
import com.project.alliance.Models.requests.RoleRequest;
import com.project.alliance.Models.responses.RoleResponse;
import com.project.alliance.Repositories.RoleRepository;
import com.project.alliance.Utils.EmployeeManagementBeanUtil;
import com.project.alliance.Utils.EncryptionUtil;
import com.project.alliance.Utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final Logger logger = LogManager.getLogger(RoleServiceImpl.class);
    @Override
    public List<RoleResponse> createRole(List<RoleRequest> roleRequest) throws Exception {
        List<RoleResponse> roleResponses = new ArrayList<>();
        for(RoleRequest rolesRequests : roleRequest){
            Role roleToSave = rolesRequests.toRole();
            roleToSave.setRoleId(generateRoleId(rolesRequests.getRoleId()));
            Role existingRole = roleRepository.findRoleByRoleId(rolesRequests.getRoleId());
            if (existingRole != null) {
                logger.info("This role already exists");
                throw new ConflictException("A role with the same name already exists!");
            }
            existingRole = roleRepository.save(roleToSave);
            RoleResponse rolesResponse = RoleResponse.fromRole(existingRole);
            logger.info("The existing role response: {}", roleToSave);
            roleResponses.add(rolesResponse);
        }

        return roleResponses;
    }

    @Override
    public RoleResponse findRoleByRoleId(String roleId) {
        Role existingRole = roleRepository.findRoleByRoleId(roleId);
        if (existingRole == null) {
            logger.info("This role cannot be found");
            throw new NotFoundException("Role not found !");
        }
        logger.info("Fetching an existing role by roleId response: {}", existingRole);
        return RoleResponse.fromRole(existingRole);
    }
    @Override
    public List<RoleResponse> fetchRoles() {
        List<Role> roles = roleRepository.findAll();
        return RoleResponse.fromRoles(roles);
    }

    private String generateRoleId(String Nennie) throws Exception {
        String rawKey = TimeUtil.now() + String.valueOf(Math.random()) + Nennie;
        String encodedKey = EncryptionUtil.hashWithSha256(rawKey);
        return encodedKey.substring(0, 22);
    }
}
