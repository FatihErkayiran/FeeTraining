package com.Management.feeTraining.Controllers;

import com.Management.feeTraining.DA0.UserDao;
import com.Management.feeTraining.DTO.UserDTO;
import com.Management.feeTraining.Entities.User;
import com.Management.feeTraining.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/")
    public void addUser(@RequestBody UserDTO user) {
        userServices.createUser(user);
    }

    @GetMapping("{id}")
    public User findUserById(@PathVariable("id") long id) {
        return userServices.findUserById(id);
    }

    @GetMapping("/get")
    public List<User> getAllUser() {
        return userServices.getAllUser();
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") long id, @RequestBody UserDTO user) {
        userServices.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userServices.deleteUser(id);
    }

//    @GetMapping("/students")
//    public List<User> getAllStudents(){return userDao.getAllStudents();}
//
//    @GetMapping("/accountants")
//    public List<User> getAllAccountants(){return userDao.getAllAccountants();}
//
//    @GetMapping("/admin")
//    public List<User> getAdmin(){return userDao.getAdmin();}
}


