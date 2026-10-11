package com.spring.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

public class EnrollmentWriteDto {

    @NotNull 
    @JsonProperty("course_id")
    private Integer courseId;

    private String grade;

    public Integer getCourseId(){
        return courseId;

    }
    public void setCourseId(Integer courseId){
        this.courseId = courseId;
    }
    public String getGrade(){
        return grade;

    }
    public void setGrade(String grade){
        this.grade = grade;
    }

    

}
