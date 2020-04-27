package com.Management.feeTraining.DTO;

import com.Management.feeTraining.Entities.User;

public class RoleDto {

    private User user;

    public RoleDto(User user) {
        this.user = user;

    }

    public RoleDto() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
