package com.Management.feeTraining.Controllers;

import com.Management.feeTraining.DA0.UserDao;
import com.Management.feeTraining.Entities.User;
import com.Management.feeTraining.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
   private UserDao userDao;

    @PostMapping()
    public void addUser(@RequestBody  User user){
        userDao.createUser(user);
    }

   @GetMapping("{id}")
    public User findUserById(@PathVariable("id") long id){
        return userDao.findUserById(id);
    }

    @GetMapping()
    public List<User> getAllStudent(){ return userDao.getAllUser(); }

    @PutMapping()
    public void updateUser(@RequestBody  User user){
        userDao.updateUser(user);
    }

    @DeleteMapping({"id"})
    public void deleteUser(@PathVariable("id") long id){
        userDao.deleteUser(id);
    }
}


