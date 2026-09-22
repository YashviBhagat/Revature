package com.cleancode.service;

import com.cleancode.domain.Student;
import java.util.List;
import com.cleancode.persistance.StudentDAO;

public class StudentServiceImp implements StudentService {
    private final StudentDAO studentDAO;

    public StudentServiceImp(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    @Override 
    public Student findStudent(int id){
        return studentDAO.getStudentById(id);
    }

    @Override 
    public void addStudent(Student student){
        if(studentDAO.getStudentById(student.getId()) != null){
            throw new IllegalArgumentException("Student ID already exists");
        }

        studentDAO.addStudent(student);

    }

    @Override 
    public List<Student> findAllStudents(){
        return studentDAO.getAllStudents();
    }



    
} 
