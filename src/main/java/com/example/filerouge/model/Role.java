package com.example.filerouge.model;

public class Role {
    private int idRole;
    private String roleName;

    public Role(int idRole, String roleName) {
        this.idRole = idRole;
        this.roleName = roleName;
    }

    public int getIdRole() {
        return idRole;
    }

    public String getRoleName() {
        return roleName;
    }
}
