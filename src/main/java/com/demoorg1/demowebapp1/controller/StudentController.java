package com.demoorg1.demowebapp1.controller;

import com.demoorg1.demowebapp1.Dto.StudentDto;
import com.demoorg1.demowebapp1.converter.StudentConverter;
import com.demoorg1.demowebapp1.domain.Student;
import com.demoorg1.demowebapp1.exception.ResourceNotFoundException;
import com.demoorg1.demowebapp1.service.impl.StudentServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api")
@Slf4j
public class StudentController {
    @Autowired
    StudentServiceImpl studentServiceImpl;


    @Operation(summary = "get all Student details",description ="get a list of Student details", tags= "Get")
    @ApiResponse(responseCode = "200", description = "Found the Student", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    @GetMapping("/students")
    public List<Student> getAllStudents(){

        return studentServiceImpl.getAllStudents();
    }



    @Operation(summary = "get Student detail by id",description ="get a list of Student details", tags= "Get")
    @ApiResponse(responseCode = "200", description = "Found the Student", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") Long id){

        return studentServiceImpl.getStudent(id);
    }



    @Operation(summary = "insert Student details", description = "Inserting  particular Student details", tags = "Post")
    @ApiResponse(responseCode = "200", description = "Inserted the Student details", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    @PostMapping("/insert")
    public String addStudent(@RequestBody Student student) {
        System.out.println(student.toString());
        Student student1 = studentServiceImpl.addStudent(student);
        if(student1==null){
            throw  new ResourceNotFoundException("Student ","id",addStudent(student1));
        }
        return "Successfully Inserted";

    }


    @Operation(summary = "update the Student details",description ="updating particular Student details", tags= "Put")
    @ApiResponse(responseCode = "200", description = "updated the Student details", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    @RequestMapping(method=RequestMethod.PUT, value="/update")
    public Student updateStudent(@RequestBody Student studentDetails){
        return  studentServiceImpl.updateStudent(studentDetails);
    }

    @Operation(summary = "Delete Student", description = "Delete a  particular Student details", tags = "Delete")
    @ApiResponse(responseCode = "200", description = "deleted the Student", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id)  {
        String delete = "successfully deleted";
        studentServiceImpl.deleteStudent(id);
        return delete;
    }


    @Operation(summary = "Get Student details by grade", description = "Native Query", tags= "Get")
    @ApiResponse(responseCode = "200", description = "Mapped Successfully", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    @GetMapping("/students/grade/{grade}")
    public List<Student> getStudentByGrade(@PathVariable("grade")  String grade){

        return studentServiceImpl.getAllStudentsByStatus(grade);
    }


    @Operation(summary = "Map Student Dto", description = "Map Student Dto", tags= "Get")
    @ApiResponse(responseCode = "200", description = "Mapped Successfully", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    @GetMapping("/map/{id}")
    public StudentDto findUserById(@PathVariable("id") Long id){
        Student studentData = studentServiceImpl.getStudent(id);
        return StudentConverter.toStudentDto(studentData);
    }


    @Operation(summary = "Pagination", description = "Delete a  particular Student details", tags= "Get")
    @ApiResponse(responseCode = "200", description = "Successful", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    @GetMapping("/paging")
    public Page<Student> studentPagination(@QueryParam("pageNo") Integer pageNumber, @QueryParam("pageSize") Integer pageSize, @QueryParam("field") String field){
        return studentServiceImpl.getStudentPagination(pageNumber,pageSize,field);
    }


}
