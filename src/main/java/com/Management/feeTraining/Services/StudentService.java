package com.Management.feeTraining.Services;

import com.Management.feeTraining.DA0.StudentDao;
import com.Management.feeTraining.DA0.StudentDaoImp;
import com.Management.feeTraining.DTO.StudentDTO;
import com.Management.feeTraining.Entities.Student;
import com.Management.feeTraining.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Service


public class StudentService  {

    @Autowired
    StudentDao studentDao;


    public StudentService(@Qualifier("aka") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    // To RETRIEVE ALL STUDENTS FROM DATABASE
    public List<Student> getAllStudents(){

       return studentDao.getAllStudents();



    }

    // To ADD A NEW STUDENT FROM DATABASE
    public void saveStudent(StudentDTO student){
     studentDao.saveStudent(student);
//
    }

    // To UPDATE A STUDENT FROM DATABASE
    public Student updateStudent(Long id, StudentDTO student2){
       return studentDao.updateStudent(id,student2);
    }
    // To FIND A STUDENT USING ID FROM DATABASE
    public Student findStudentById(long id ){
       return studentDao.findStudentById(id);
    }

    //To DELETE A STUDENT FROM DATABASE
    public void deleteStudent(long id){
        studentDao.deleteStudent(id);

    }



}
