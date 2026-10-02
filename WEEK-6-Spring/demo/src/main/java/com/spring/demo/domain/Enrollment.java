package com.spring.demo.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity 
@Table (name="enrollment")

public class Enrollment {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    //localDate type = YYYY-mm-dd "2026-10-02"
    @NotNull 
    @Column(name="enrollment_date",nullable=false)
    private LocalDate enrollmentDate;

    @Column (name = "grade")
    private String grade;

    @ManyToOne(optional = false)
    @NotNull 
    @JoinColumn (name="course_id",nullable = false)
    private Course course;

    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public Enrollment(){}

    public Enrollment(Student student,LocalDate enrollmentDate, String grade, @NotNull Course course) {
        this.enrollmentDate = enrollmentDate;
        this.student = student;
        this.grade = grade;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
