package com.Management.feeTraining.Controllers;


import com.Management.feeTraining.DA0.StudentDao;
import com.Management.feeTraining.DTO.StudentDTO;
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
    StudentService studentService;


    @PostMapping
    public void saveStudent(@RequestBody StudentDTO student) {
        studentService.saveStudent(student);

    }

    @GetMapping(headers = "Accept=application/json")
    public List<Student > getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/{id}")
    public Student  updateStudent(@PathVariable("id") Long id, @RequestBody StudentDTO  student) {
        return studentService.updateStudent(id, student);

    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/{id}")
    public Student  findUserById(@PathVariable("id") Long id) {
        return studentService.findStudentById(id);
    }


}