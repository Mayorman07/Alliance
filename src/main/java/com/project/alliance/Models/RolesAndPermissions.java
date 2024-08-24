package com.project.alliance.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;
@Entity
@Table(name = "roles_and_permissions")
public class RolesAndPermissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleId;
    private String permissionId;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}


