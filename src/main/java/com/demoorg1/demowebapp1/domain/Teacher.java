package com.demoorg1.demowebapp1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Entity
@Table(name="teacher")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(name="teach_name")
    private String name;
    private String subject;
  @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
