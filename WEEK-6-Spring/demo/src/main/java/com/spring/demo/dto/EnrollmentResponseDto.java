package com.spring.demo.dto;

import java.time.LocalDate;

import com.spring.demo.domain.Enrollment;

public class EnrollmentResponseDto {

    private Integer id;
    private Integer studentId;
    private String studentName;
    private Integer courseId;
    private String courseName;
    private LocalDate enrollmentDate;
    private String grade;

    public EnrollmentResponseDto(Enrollment enrollment){
        this.id = enrollment.getId();
        this.studentId = enrollment.getStudent().getId();
        this.studentName = enrollment.getStudent().getFirstName() + " " + enrollment.getStudent().getLastName();
        this.courseId = enrollment.getCourse().getId();
        this.courseName = enrollment.getCourse().getName();
        this.enrollmentDate = enrollment.getEnrollmentDate();
        this.grade = enrollment.getGrade();
    }

    public Integer getId() {
        return id;
    }

    
    public Integer getStudentId() {
        return studentId;
    }

    

    public String getStudentName() {
        return studentName;
    }

   
    public Integer getCourseId() {
        return courseId;
    }

    

    public String getCourseName() {
        return courseName;
    }

    

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    

    public String getGrade() {
        return grade;
    }

    


}
