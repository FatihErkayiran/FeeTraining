package com.Management.feeTraining.DA0;

import com.Management.feeTraining.Entities.Student;

import java.util.List;

public interface StudentDao {

    public List<Student> getAllStudents();
    public void saveStudent(Student student);
    public Student updateStudent(Long id, Student student2);
    public Student findStudentById(long id );
    public void deleteStudent(long id);

}
