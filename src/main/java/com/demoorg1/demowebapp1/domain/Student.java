package com.demoorg1.demowebapp1.domain;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name="student")
@Getter
@Setter
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Student name should not be null")
    @Column(name="stu_name")
    private String name;
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message = "grade field required it cannot be null")
    private String grade;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fk_add_id")
    private Address address;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "stu_id",referencedColumnName="id")
    private List<Teacher> teacher;

    @OneToMany(mappedBy="student")
    private List<Teacher> teachers;

}
