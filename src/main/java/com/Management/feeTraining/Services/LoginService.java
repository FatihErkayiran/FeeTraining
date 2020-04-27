package com.Management.feeTraining.Services;

import com.Management.feeTraining.Entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    @Autowired
    SessionFactory sessionFactory;


    public Session getSession(){
        Session session=sessionFactory.getCurrentSession();
        if (session==null){
            session=sessionFactory.openSession();
            return session;
        }
        return session;
    }

    public User findUserById(long id){
        return getSession().get(User.class,id);
    }


    public User authUser(long id, String password){
         User user=findUserById(id);
         if (user !=null && user.getPassword().equals(password)){
             return user;
         }return null;

    }




}
