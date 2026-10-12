package com.spring.demo.rest;

import java.util.List;

import com.spring.demo.domain.Student;
import com.spring.demo.service.StudentService;


import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.data.domain.Pageable;
import com.spring.demo.dto.StudentWriteDto;


@Controller 
public class StudentGraphController {
    private StudentService studentService;
    public StudentGraphController(StudentService studentService){
        this.studentService = studentService;
    }

    @QueryMapping 
    public List <Student> students(){
        return studentService.getAllStudents(Pageable.unpaged());
    }
    

    @QueryMapping 
    public Student studentById(@Argument int id){
        return studentService.getStudentById(id);
    }

    @MutationMapping
    public Student createStudent(
        @Argument String firstName,
        @Argument String lastName,
        @Argument String email,
        @Argument Integer schoolId){
            StudentWriteDto dto = new StudentWriteDto();
            dto.setFirstName(firstName);
            dto.setLastName(lastName);
            dto.setEmail(email);
            dto.setSchoolId(schoolId);

            return studentService.insertStudent(dto);
            
    

}
}
