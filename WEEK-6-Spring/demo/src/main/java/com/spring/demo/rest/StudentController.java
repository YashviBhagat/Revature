package com.spring.demo.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.spring.demo.domain.Student;
import com.spring.demo.service.StudentService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;



@RestController 
@RequestMapping ("/api/students")
public class StudentController {

    private final StudentService studentService;

    
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //GET localhost:8080/api/students/test
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    } 

    
    @PostMapping 
    public ResponseEntity<Student> insertStudent(@Valid @RequestBody Student student){

        Student savedStudent = studentService.insertStudent(student);

        //localhost:808/api/students/{id}
        return ResponseEntity
            .created(
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedStudent.getId())
                    .toUri()
            )
            .body(savedStudent);
    }
    //route parameter - typically used for resource location
    //GET http://localhost:8080/api/students/3

    //query parameter - typically filtering and searching
    //GET http://localhost:8080/api/students?lastname=bhagat&grade=b
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }
    
    


}
