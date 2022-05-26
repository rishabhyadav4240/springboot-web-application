package com.demoorg1.demowebapp1.service;

import com.demoorg1.demowebapp1.domain.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudent(Long id);
    Student addStudent(Student student);
   Student updateStudent(Student student);
    void deleteStudent(Long id);

}




