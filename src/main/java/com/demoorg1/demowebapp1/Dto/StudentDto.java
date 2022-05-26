package com.demoorg1.demowebapp1.Dto;

import com.demoorg1.demowebapp1.domain.Teacher;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudentDto {
    private String name;
    private String email;
    private List<Teacher> teachers;
}
