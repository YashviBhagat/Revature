package com.spring.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.demo.dao.CourseRepository;
import com.spring.demo.dao.EnrollmentRepository;
import com.spring.demo.dao.SchoolRepository;
//import com.spring.demo.dao.StudentDAO;
import com.spring.demo.dao.StudentRepository;
import com.spring.demo.domain.School;
import com.spring.demo.domain.Student;
import com.spring.demo.dto.StudentWriteDto;
import com.spring.demo.exceptions.RecordNotFoundException;

import org.springframework.transaction.annotation.Transactional;

@Service 
public class StudentService {
    //private final StudentDAO studentDAO;
    private final StudentRepository studentRepo;
    private final SchoolRepository schoolRepo;
    private final EnrollmentRepository enrollmentRepo;
    private final CourseRepository courseRepo;
    private static final Logger log = LoggerFactory.getLogger(StudentService.class);

     public StudentService(//@Qualifier("entityManagerStudentDAO")StudentDAO studentDAO,
        StudentRepository studentRepository,
        SchoolRepository schoolRepository,
        EnrollmentRepository enrollmentRepository,
        CourseRepository courseRepository)
    {
        //this.studentDAO = studentDAO;
        this.studentRepo = studentRepository; 
        this.schoolRepo = schoolRepository;
        this.enrollmentRepo = enrollmentRepository;
        this.courseRepo = courseRepository;

    }

    @Transactional 
    public Student insertStudent(StudentWriteDto student){
        School school = schoolRepo.findById(student.getSchoolId())
            .orElse(null);
        Student newStudent = new Student(
            student.getFirstName(),
            student.getLastName(),
            student.getEmail(),
            school
        );

        return studentRepo.save(newStudent);
    }

    // @Transactional 
    // public School insertSchool(School school){
    //     return schoolRepo.save(school);
    // }

    @Transactional 
    public List<Student> findStudentBySchoolNAme(String name){
        return studentRepo.findBySchool_Name(name);
    }

   @Transactional(readOnly = true)
    public List<Student> getAllStudents(Pageable pageable) {
        return studentRepo.findAll(pageable).getContent();
}


    @Transactional (readOnly = true)
    public Student getStudentById(int id){
        Student student = studentRepo.findById(id)
        .orElseThrow(()->
            new RecordNotFoundException(
                "Student not found with id:" + id
            )
        );

        
        return student;
    }

    @Transactional
    public void deleteStudent(int id){
        Student student = getStudentById(id);
        studentRepo.delete(student);
    }

    @Transactional(readOnly = true)
    public List<Student> getStudentByLastName(String lastName){
        return studentRepo.findByLastName(lastName);
    }
    // we don't need a call to DAO here
    //since this is a transaction and existingStudent is a 
    //managed entity any changes to it will be tracked
    //before the transaction closes dirty checking will occur 
    //this wi;; detect the charge to the manage entity and the changes will commit 
    @Transactional 
    public Student updateStudent(int id,Student student){
        Student existingStudent = getStudentById(id);

        existingStudent.setEmail(student.getEmail());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());

        return existingStudent;


    }

    // @Transactional(readOnly = true) 
    // public School getSchoolById(int id){
    //     School school = schoolRepo.findById(id)
    //     .orElseThrow(()->
    //         new RecordNotFoundException(
    //             "School not found with id:" + id
    //         )
    //     );

        
    //     return school;
    // }


    

}
