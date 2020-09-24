package com.Management.feeTraining.DA0;



import com.Management.feeTraining.DTO.StudentDTO;
import com.Management.feeTraining.Entities.Student;


import java.util.List;

public interface StudentDao {

    public List<Student> getAllStudents();

    public void saveStudent(StudentDTO studentDTO);

    public Student updateStudent(Long id, StudentDTO student2);

    public Student findStudentById(long id);

    public void deleteStudent(long id);

}