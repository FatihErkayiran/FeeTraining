package com.Management.feeTraining.DA0;

import com.Management.feeTraining.DTO.StudentDTO;
import com.Management.feeTraining.Entities.Student;
import com.Management.feeTraining.Entities.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository("aka")
@Transactional
public class StudentDaoImp implements StudentDao{

    @Autowired
    SessionFactory sessionFactory;

    // To RETRIEVE ALL STUDENTS FROM DATABASE
    public List<Student> getAllStudents(){
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        Root<Student> myObjectRoot = criteria.from(Student.class);
        criteria.select(myObjectRoot);
        TypedQuery<Student> query = session.createQuery(criteria);

        return query.getResultList();



    }

    // To ADD A NEW STUDENT FROM DATABASE
    public void saveStudent(StudentDTO student){
        Session session=sessionFactory.getCurrentSession();
//        session.save(studentDTO);
        Student student1=new Student();
        student1.setStudent_due(student.getStudent_due());
        student1.setStudent_fee(student.getStudent_fee());
        student1.setStudent_paid(student.getStudent_paid());
        student1.setStudent_name(student.getStudent_name());
        student1.setStudent_course(student.getStudent_course());
        student1.setStudent_address(student.getStudent_address());
        student1.setStudent_contact(student.getStudent_contact());

        User user=session.get(User.class, student.getUser_id());

        student1.setUser(user);
        //   session.saveOrUpdate(student1);



//        Session session=sessionFactory.getCurrentSession();
//      //  Transaction transaction =session.beginTransaction();
        session.save(student1);
//      //  transaction.commit();
    }

    // To UPDATE A STUDENT FROM DATABASE
    public Student updateStudent(Long id, StudentDTO student2){
        Session session=sessionFactory.getCurrentSession();
        Student student1=findStudentById(id);
        student1.setStudent_due(student2.getStudent_due());
        student1.setStudent_fee(student2.getStudent_fee());
        student1.setStudent_paid(student2.getStudent_paid());
        student1.setStudent_name(student2.getStudent_name());
        student1.setStudent_course(student2.getStudent_course());
        student1.setStudent_address(student2.getStudent_address());
        student1.setStudent_contact(student2.getStudent_contact());
        // session.beginTransaction();
        session.save(student1);
        // session.getTransaction().commit();
        return student1;

    }
    // To FIND A STUDENT USING ID FROM DATABASE
    public Student findStudentById(long id ){
        Session session=sessionFactory.getCurrentSession();
        return session.find(Student.class,id);

    }

    //To DELETE A STUDENT FROM DATABASE
    public void deleteStudent(long id){
        Session session=sessionFactory.getCurrentSession();
        Student student1=findStudentById(id);
        //  session.beginTransaction();
        session.delete(student1);
        // session.getTransaction().commit();

    }



}


