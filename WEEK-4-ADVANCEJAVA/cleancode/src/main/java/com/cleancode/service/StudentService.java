package com.cleancode.service;

import com.cleancode.domain.Student;
import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    List<Student> findAllStudents();
    Student findStudent(int id);

    
} 
