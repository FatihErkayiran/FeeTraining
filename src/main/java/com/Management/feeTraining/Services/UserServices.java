package com.Management.feeTraining.Services;

import com.Management.feeTraining.DA0.UserDao;
//import com.Management.feeTraining.Entities.Accountant;
//import com.Management.feeTraining.Entities.Student;
import com.Management.feeTraining.Entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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


    public List<User> getAllUser(){
        Session session=sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> myObjectRoot = criteria.from(User.class);
        criteria.select(myObjectRoot);
        TypedQuery<User> query = session.createQuery(criteria);
        return query.getResultList();
    }

    public void updateUser(User user){
        Session session=sessionFactory.getCurrentSession();
        User user1=findUserById(user.getUser_id());
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        user1.setAddress(user.getAddress());
        user1.setContact(user.getContact());
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

    public  List<User> getAllStudents(){
        Session session=sessionFactory.getCurrentSession();
        String hql = "from User  where role_id=45";
        Query query = session.createQuery(hql);
        return query.list();
    }

    public List<User> getAllAccountants(){
        Session session=sessionFactory.getCurrentSession();
        String hql = "from User  where role_id=35";
        Query query = session.createQuery(hql);
        return query.list();

    }

    public List<User> getAdmin(){
        Session session=sessionFactory.getCurrentSession();
        String hql = "from User  where role_id=25";
        Query query = session.createQuery(hql);
        return query.list();

    }

//    public void saveStudent(Student student){
//        Session session=sessionFactory.getCurrentSession();
//        Transaction transaction =session.beginTransaction();
//        session.save(student);
//        transaction.commit();
//    }
//
//
//    public Student updateStudent(Long id, Student student2){
//        Session session=sessionFactory.getCurrentSession();
//        Student student1=findStudentById(id);
//        student1.setStudent_due(student2.getStudent_due());
//        student1.setStudent_fee(student2.getStudent_fee());
//        student1.setStudent_paid(student2.getStudent_paid());
//        student1.setStudent_name(student2.getStudent_name());
//        student1.setStudent_course(student2.getStudent_course());
//        student1.setStudent_address(student2.getStudent_address());
//        student1.setStudent_contact(student2.getStudent_contact());
//        student1.setStudent_email(student2.getStudent_email());
//        session.beginTransaction();
//        session.save(student1);
//        session.getTransaction().commit();
//        return student1;
//
//    }
//
//    public Student findStudentById(long id ){
//        Session session=sessionFactory.getCurrentSession();
//        return session.find(Student.class,id);
//    }
//
//    public void deleteStudent(long id){
//        Session session=sessionFactory.getCurrentSession();
//        Student student1=findStudentById(id);
//        session.beginTransaction();
//        session.delete(student1);
//        session.getTransaction().commit();
//
//    }
//
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
