package com.demoorg1.demowebapp1.repository;

import com.demoorg1.demowebapp1.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
