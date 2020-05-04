package com.Management.feeTraining.Controllers;


import com.Management.feeTraining.DA0.StudentDao;
import com.Management.feeTraining.Entities.Student;
import com.Management.feeTraining.Entities.User;
import com.Management.feeTraining.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {


    @Autowired
    StudentDao studentDao;


    @PostMapping
    public void saveStudent(@RequestBody Student student){
        studentDao.saveStudent(student);

    }

    @GetMapping
    public List<Student> getAllStudents(){
        return   studentDao.getAllStudents();
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("id") Long id,@RequestBody Student student){
        return studentDao.updateStudent(id,student);

    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        studentDao.deleteStudent(id);
    }

    @GetMapping("/{id}")
    public Student findUserById(@PathVariable("id") Long id){
        return studentDao.findStudentById(id);
    }


}