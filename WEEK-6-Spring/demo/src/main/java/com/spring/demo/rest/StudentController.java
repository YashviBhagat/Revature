package com.spring.demo.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.spring.demo.domain.Student;
import com.spring.demo.dto.StudentWriteDto;
import com.spring.demo.domain.School;
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


    /*
        ANTI-PATTERNS - DON'T DO STUFF LIKE THIS
        http://localhost:8080/students/getstudent
    */

    //GET localhost:8080/api/students/test
    @GetMapping
    public List<Student> getAllStudents(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int count,
        @RequestParam(defaultValue = "true") boolean asc
    ){
        
        return studentService.getAllStudents(page,count,asc);
    } 

    
    @PostMapping 
    public ResponseEntity<Student> insertStudent(@Valid @RequestBody StudentWriteDto student){

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
    
    // @PostMapping 
    // public ResponseEntity<School> insertSchool(@Valid @RequestBody School school){

    //     School savedSchool = studentService.insertSchool(school);

    //     //
    //     return ResponseEntity
    //         .created(
    //             ServletUriComponentsBuilder
    //                 .fromCurrentRequest()
    //                 .path("/{id}")
    //                 .buildAndExpand(savedSchool.getId())
    //                 .toUri()
    //         )
    //         .body(savedSchool);
    // }
    //route parameter - typically used for resource location
    //GET http://localhost:8080/api/students/3

    //query parameter - typically filtering and searching
    //GET http://localhost:8080/api/students?lastname=bhagat&grade=b
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @GetMapping(params = "lastName")
    public List<Student> getStudentByLastName(@RequestParam  String lastName){
        return studentService.getStudentByLastName(lastName);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable  int id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @GetMapping
    public List<Student> getStudentBySchoolName(@RequestParam  String school){
        return studentService.findStudentBySchoolNAme(school);
    }
    
    
    


}
