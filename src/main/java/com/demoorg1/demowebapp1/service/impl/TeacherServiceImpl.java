package com.demoorg1.demowebapp1.service.impl;

import com.demoorg1.demowebapp1.domain.Student;
import com.demoorg1.demowebapp1.domain.Teacher;
import com.demoorg1.demowebapp1.exception.ResourceNotFoundException;
import com.demoorg1.demowebapp1.repository.StudentRepository;
import com.demoorg1.demowebapp1.repository.TeacherRepository;
import com.demoorg1.demowebapp1.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
@Autowired
    TeacherRepository teacherRepository;

@Autowired
StudentRepository studentRepository;

    @Override
    public List<Teacher> getTeacherByStudentId(Long id) {


       Student studentOptional = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

        return studentOptional.getTeacher();
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return null;
    }

    @Override
    public Teacher getTeacher(Long id) {
        return null;
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public void deleteTeacher(Long id) {

    }
}
