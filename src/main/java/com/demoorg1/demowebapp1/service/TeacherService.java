package com.demoorg1.demowebapp1.service;



import com.demoorg1.demowebapp1.domain.Teacher;

import java.util.List;

public interface TeacherService {


    List<Teacher> getTeacherByStudentId(Long id);

    List<Teacher> getAllTeachers();
    Teacher getTeacher(Long id);
    Teacher addTeacher(Teacher teacher);
    Teacher updateTeacher(Teacher teacher);
    void deleteTeacher(Long id);
}
