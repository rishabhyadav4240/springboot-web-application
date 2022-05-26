package com.demoorg1.demowebapp1.repository;


import com.demoorg1.demowebapp1.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "Select * from student s where s.grade=?1",nativeQuery = true)
    List<Student> getStudentByGrade(String grade);
}
