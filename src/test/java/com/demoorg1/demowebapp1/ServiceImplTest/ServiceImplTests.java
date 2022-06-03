package com.demoorg1.demowebapp1.ServiceImplTest;

import com.demoorg1.demowebapp1.domain.Student;
import com.demoorg1.demowebapp1.service.impl.StudentServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class ServiceImplTests {


        @Autowired
        StudentServiceImpl studentServiceImpl;



        @Test
        public void  saveStudent(){
            //given
            Student student = Student.builder()
                    .name("ramesh")
                    .email("shubham@gmail.com")
                    .grade("Average")
                    .address(null)
                    .build();
            //when
            studentServiceImpl.addStudent(student);

            //then
            Assertions.assertThat(student.getId()).isGreaterThan(0);
        }

        @Test
        public void getStudentById(){

            //given
            // when
            Student student=studentServiceImpl.getStudent(8L);
            //then
            Assertions.assertThat(student.getId()).isEqualTo(8L);

        }

        @Test
        public void updateStudent(){
            //given
            Student student =  studentServiceImpl.getStudent(9L);
            //when
            student.setEmail("rishabh12345@gmail.com");
            //then
            Assertions.assertThat(student.getEmail()).isEqualTo("rishabh12345@gmail.com");
        }

    }


