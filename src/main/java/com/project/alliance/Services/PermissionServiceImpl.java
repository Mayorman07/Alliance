package com.project.alliance.Services;

import com.project.alliance.Exceptions.ConflictException;
import com.project.alliance.Interfaces.PermissionsService;
import com.project.alliance.Models.Permission;
import com.project.alliance.Models.requests.PermissionRequest;
import com.project.alliance.Models.responses.PermissionResponse;
import com.project.alliance.Repositories.PermissionRepository;
import com.project.alliance.Utils.EncryptionUtil;
import com.project.alliance.Utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class PermissionServiceImpl implements PermissionsService {

    private final PermissionRepository permissionRepository;
    private PermissionResponse permissionResponse;

    //    private final ObjectMapper objectMapper;
    private final Logger logger = LogManager.getLogger(PermissionServiceImpl.class);

    @Override
    public List<PermissionResponse> createPermission(List<PermissionRequest> permissionRequest) throws Exception {

        List<PermissionResponse> permissionResponses = new ArrayList<>();

        for(PermissionRequest permissionsRequest : permissionRequest){
            Permission permissionToSave = permissionsRequest.toPermissions();
            permissionToSave.setPermissionId(generatePermissionId(permissionsRequest.getPermissionId()));
            Permission savedPermissions = permissionRepository.findPermissionByName(permissionsRequest.getName());
            if (savedPermissions != null) {
                logger.info("The Permission already exists");
                throw new ConflictException("Permission with the same name already exists");
            }
            savedPermissions = permissionRepository.save(permissionToSave);
            PermissionResponse permissionResponse = PermissionResponse.fromPermissions(savedPermissions);
            logger.info("Saved permission response: {}", permissionToSave);
            permissionResponses.add(permissionResponse);
        }
        return permissionResponses;
    }

    @Override
    public List<PermissionResponse> fetchPermissions() {
        List<Permission> permissions = permissionRepository.findAll();
        logger.info("Fetched all permissions response: {}", permissions);
        return PermissionResponse.fromPermissionsList(permissions);
    }

    private String generatePermissionId(String permissionName) throws Exception {
        String rawKey = TimeUtil.now() + String.valueOf(Math.random()) + permissionName;
        String encodedKey = EncryptionUtil.hashWithSha256(rawKey);
        return encodedKey.substring(0, 22);
    }
}
