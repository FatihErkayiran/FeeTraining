package com.Management.feeTraining.Controllers;


import com.Management.feeTraining.DA0.UserDao;
import com.Management.feeTraining.DTO.RoleDto;
import com.Management.feeTraining.Entities.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roles")
public class RoleController {

@Autowired
    UserDao userDao;

    @GetMapping()
    public List<User> getAllStudent(){ return userDao.getAllUser(); }

    @PostMapping()
    public void addUser(@RequestBody RoleDto roleDto){
        userDao.createUser(roleDto.getUser());
    }


}

