package com.Management.feeTraining.DA0;

import com.Management.feeTraining.Entities.User;

import java.util.List;

public interface UserDao {

    public void createUser(User user);
    public User findUserById(long id);
    public List<User> getAllUser();
    public void updateUser(User user);
    public void deleteUser(long id);

}
