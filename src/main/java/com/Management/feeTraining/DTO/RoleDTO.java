package com.Management.feeTraining.DTO;

import com.Management.feeTraining.Entities.RoleName;

public class RoleDTO {

    private long role_id;
    private RoleName role_Name;

    public RoleDTO(long role_id, RoleName role_Name) {
        this.role_id = role_id;
        this.role_Name = role_Name;
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public RoleName getRole_Name() {
        return role_Name;
    }

    public void setRole_Name(RoleName role_Name) {
        this.role_Name = role_Name;
    }
}
