package com.Management.feeTraining.DA0;

import com.Management.feeTraining.DTO.UserDTO;
import com.Management.feeTraining.Entities.User;

import java.util.List;

public interface UserDao {

    public void createUser(UserDTO userDTO);

    public User findUserById(long id);

    public List<User> getAllUser();

    public void updateUser(long id, UserDTO user);

    public void deleteUser(long id);

    public User findUserByName(String name);

}
