package com.demoorg1.demowebapp1.service.impl;

import com.demoorg1.demowebapp1.domain.Student;
import com.demoorg1.demowebapp1.exception.ResourceNotFoundException;
import com.demoorg1.demowebapp1.repository.StudentRepository;
import com.demoorg1.demowebapp1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;






    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
    }

    @Override
    public Student addStudent(Student student) {

        return studentRepository.save(student);
    }
  @Override
   public Student updateStudent(Student studentDetails) {
      Student student = studentRepository.findById(studentDetails.getId())
              .orElseThrow(() -> new ResourceNotFoundException("Student","id",studentDetails.getId()));

      student.setEmail(studentDetails.getEmail());

       return studentRepository.save(student);
    }

   @Override
   public void deleteStudent(Long id) {
       Student student = studentRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Student","id",id));
       studentRepository.deleteById(id);
    }

    public List<Student> getAllStudentsByStatus(String grade) {

        return studentRepository.getStudentByGrade(grade);
    }

    public Page<Student> getStudentPagination(Integer pageNumber,Integer pageSize,String field){
        Pageable pageable= PageRequest.of(pageNumber,pageSize, Sort.Direction.ASC, "name");
        return studentRepository.findAll(pageable);
    }

    }



