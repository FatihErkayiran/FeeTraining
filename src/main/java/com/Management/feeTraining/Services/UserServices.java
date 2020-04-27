package com.Management.feeTraining.Services;

import com.Management.feeTraining.DA0.UserDao;
import com.Management.feeTraining.Entities.Student;
import com.Management.feeTraining.Entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices implements UserDao {


    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession(){
        Session session=sessionFactory.getCurrentSession();
        if (session==null){
            session=sessionFactory.openSession();
            return session;
        }
        return session;
    }


    public void createUser(User user){
        Session session=sessionFactory.openSession();
        session.beginTransaction();



        session.save(user);
        session.getTransaction().commit();


    }

    public User findUserById(long id){
       return getSession().get(User.class,id);
    }

    @SuppressWarnings("deprecation")
    public List<User> getAllUser(){
        List<User>list=getSession().createCriteria(User.class).list();
        return list;
    }

    public void updateUser(User user){
        Session session=sessionFactory.getCurrentSession();
        User user1=findUserById(user.getUser_id());
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        session.beginTransaction();
        session.saveOrUpdate(user1);
        session.getTransaction().commit();

    }

    public void deleteUser(long id) {
        Session session = sessionFactory.getCurrentSession();

       // User user = findUserById(id);

//        Transaction transaction=session.getTransaction();
//        transaction.begin();
//        session.delete(findUserById(id));
//        transaction.commit();

          session.delete(id);
    }
}
