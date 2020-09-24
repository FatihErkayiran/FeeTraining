package com.Management.feeTraining.DA0;

import com.Management.feeTraining.DTO.UserDTO;
import com.Management.feeTraining.Entities.Role;
import com.Management.feeTraining.Entities.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Repository("bbb")
@Transactional
public class UserDaoImp implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;



    // To ADD A NEW USER FROM DATABASE
    public void createUser(UserDTO userDTO) {
        Session session = sessionFactory.getCurrentSession();
        User user1=new User();
        user1.setName(userDTO.getName());
        user1.setEmail(userDTO.getEmail());
        user1.setPassword(userDTO.getPassword());
        user1.setAddress(userDTO.getAddress());
        user1.setContact(userDTO.getContact());

        Role role =session.get(Role.class, userDTO.getRole_id());
        role.setRole_id(userDTO.getRole_id());
        user1.setRoles((Set<Role>) role);
        //User user=session.get(User.class, student.getUser_id());
        //
        //        student1.setUser(user);

    }

    // To FIND A USER USING ID FROM DATABASE
    public User findUserById(long id) {
        Session session=sessionFactory.getCurrentSession();
       User user=session.get(User.class, id);
        //Hibernate.initialize(user.getRoles());
        return user;
    }

    // To RETRIEVE ALL USER FROM DATABASE
    public List<User> getAllUser() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> myObjectRoot = criteria.from(User.class);
        criteria.select(myObjectRoot);
        TypedQuery<User> query = session.createQuery(criteria);
         Hibernate.initialize(query.getResultList());
        return query.getResultList();



    }


    // To UPDATE A USER FROM DATABASE
    public void updateUser(long id, UserDTO user) {
        Session session = sessionFactory.getCurrentSession();
        User user1 = findUserById(id);
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        user1.setAddress(user.getAddress());
        user1.setContact(user.getContact());

        session.saveOrUpdate(user1);


    }

    //To DELETE A USER FROM DATABASE
    public void deleteUser(long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = findUserById(id);
        //session.beginTransaction();
        session.delete(user);
        //session.getTransaction().commit();
    }

    public User findUserByName(String name){
        Query<User> query = sessionFactory.getCurrentSession().createQuery("FROM User u where u.username=:username", User.class);
        query.setParameter("username", name);
        return query.uniqueResult();
//      Session session=sessionFactory.getCurrentSession();
//      User user=session.find(User.class,name);
//      return user;
    }
}
