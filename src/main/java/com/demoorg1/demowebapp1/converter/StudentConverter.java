package com.demoorg1.demowebapp1.converter;


import com.demoorg1.demowebapp1.Dto.StudentDto;
import com.demoorg1.demowebapp1.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


public class StudentConverter {
    public static StudentDto toStudentDto(Student student){
        if(student == null){
            return null;
        }
        return StudentDto.builder()
                .name(student.getName())
                .email(student.getEmail())
                .teachers(student.getTeacher())
                .build();
    }

    public static   Student toStudent(Student studentDto){
        if(studentDto==null){
            return null;
        }
        return Student.builder()
                .name(studentDto.getName())
                .email(studentDto.getEmail())
                .teacher(studentDto.getTeachers())
                .build();


    }

    public static List<Student> ToStudentDtoS (List<Student> studentDtoList){
        return  studentDtoList.stream().map(a -> toStudent(a)).collect(Collectors.toList());
    }

    public static List<StudentDto> StudentDTOs(List<Student> students){
        return students.stream().map(a -> toStudentDto(a)).collect(Collectors.toList());
    }
}
