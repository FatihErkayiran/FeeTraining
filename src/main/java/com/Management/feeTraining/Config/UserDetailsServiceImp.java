package com.Management.feeTraining.Config;

import com.Management.feeTraining.DA0.UserDetailsImp;
import com.Management.feeTraining.Entities.User;
import com.Management.feeTraining.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    UserServices userServices;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

       User user= userServices.findUserByName(name);
        return new UserDetailsImp(user);

    }
}

