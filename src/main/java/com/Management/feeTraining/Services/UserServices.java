package com.Management.feeTraining.Services;

import com.Management.feeTraining.DA0.UserDao;
import com.Management.feeTraining.DTO.UserDTO;
import com.Management.feeTraining.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServices implements UserDao {

    public UserServices(@Qualifier("bbb") UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
  private UserDao userDao;

    // To ADD A NEW USER FROM DATABASE
    public void createUser(UserDTO userdto) {

         userDao.createUser(userdto);

    }

    // To FIND A USER USING ID FROM DATABASE
    public User findUserById(long id) {
        return userDao.findUserById(id);
    }

    // To RETRIEVE ALL USER FROM DATABASE
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    // To UPDATE A USER FROM DATABASE
    public void updateUser(long id, UserDTO userdto) {
       userDao.updateUser(id,userdto);

    }

    //To DELETE A USER FROM DATABASE
    public void deleteUser(long id) {
       userDao.deleteUser(id);
    }

    public User findUserByName(String name){
        return userDao.findUserByName(name);
    }


//

//
//    public Accountant getAccountantById(long id){
//        Session session=sessionFactory.getCurrentSession();
//        return session.find(Accountant.class,id);
//    }
//
//    public void addAccountant(Accountant accountant){
//        Session session=sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        session.save(accountant);
//        session.getTransaction().commit();
//    }
//
//    public Accountant updateAccountant(long id,Accountant accountant){
//        Session session=sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Accountant accountant1=getAccountantById(id);
//        accountant1.setName(accountant.getName());
//        accountant1.setEmail(accountant.getEmail());
//        accountant1.setPassword(accountant.getPassword());
//        accountant1.setAddress(accountant.getAddress());
//        accountant1.setContact(accountant.getContact());
//        session.update(accountant1);
//        session.getTransaction().commit();
//        return accountant1;
//    }
//
//    public void deleteAccountant(long id){
//        Session session=sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Accountant accountant=getAccountantById(id);
//        session.delete(accountant);
//        session.getTransaction().commit();
//    }


}
