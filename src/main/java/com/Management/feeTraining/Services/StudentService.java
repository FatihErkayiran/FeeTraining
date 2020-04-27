package com.Management.feeTraining.Services;

import com.Management.feeTraining.DA0.StudentDao;
import com.Management.feeTraining.Entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements StudentDao {

    @Autowired
    SessionFactory sessionFactory;


    public List<Student> getAllStudents(){
        Session session=sessionFactory.getCurrentSession();

        List<Student> list=session.getSession().createCriteria(Student.class).list();

        return list;

    }

    public void saveStudent(Student student){
        Session session=sessionFactory.getCurrentSession();
        Transaction transaction =session.beginTransaction();
        session.save(student);
        transaction.commit();
    }


    public Student updateStudent(Long id, Student student2){
        Session session=sessionFactory.getCurrentSession();
        Student student1=findStudentById(id);
        student1.setStudent_due(student2.getStudent_due());
        student1.setStudent_fee(student2.getStudent_fee());
        student1.setStudent_paid(student2.getStudent_paid());
        student1.setStudent_name(student2.getStudent_name());
        student1.setStudent_course(student2.getStudent_course());
        student1.setStudent_address(student2.getStudent_address());
        student1.setStudent_contact(student2.getStudent_contact());
        student1.setStudent_email(student2.getStudent_email());
        session.beginTransaction();
        session.save(student1);
        session.getTransaction().commit();
        return student1;

    }

    public Student findStudentById(long id ){
        Session session=sessionFactory.getCurrentSession();
        return session.find(Student.class,id);
    }

    public void deleteStudent(long id){
        Session session=sessionFactory.getCurrentSession();
        Student student1=findStudentById(id);
        session.beginTransaction();
        session.delete(student1);
        session.getTransaction().commit();

    }



}
