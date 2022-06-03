package com.demoorg1.demowebapp1.controller;

import com.demoorg1.demowebapp1.domain.Teacher;
import com.demoorg1.demowebapp1.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")

public class TeacherController {
@Autowired
TeacherServiceImpl teacherServiceImpl;


    @GetMapping(value = "/teachers/{id}/students", produces = "application/json")
    public List<Teacher> getAllTeachersByStudentId(@PathVariable("id") Long id)
    {
        return teacherServiceImpl.getTeacherByStudentId(id);
    }
}
