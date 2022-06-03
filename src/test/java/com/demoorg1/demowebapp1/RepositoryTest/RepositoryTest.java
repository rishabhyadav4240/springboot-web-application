package com.demoorg1.demowebapp1.RepositoryTest;



import com.demoorg1.demowebapp1.domain.Address;
import com.demoorg1.demowebapp1.domain.Student;
import com.demoorg1.demowebapp1.repository.StudentRepository;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;
import org.hibernate.annotations.OrderBy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private StudentRepository studentRepository;



    @Test
    @Order(2)
    public void saveStudent() {
        //given
        Student student = Student.builder()
                .name("Shubham")
                .email("shubham@gnail.com")
                .grade("Average")
                .address(null)
                .build();
        //when
        studentRepository.save(student);

        // then
        Assertions.assertThat(student.getId()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void deleteStudent(){
        //given
        Student student = Student.builder()
                .name("Karan")
                .email("karan@gnail.com")
                .grade("Excellent")
                .address(null)
                .build();
        //when
        studentRepository.delete(student);
        //then
        Assertions.assertThat(student.getId()).isEqualTo(0);
    }

    @Test
    public void getStudentTest() {
        //given
        //when
        Student student = studentRepository.findById(8L).get();
        //then
        Assertions.assertThat(student.getId()).isEqualTo(8L);
    }




}
