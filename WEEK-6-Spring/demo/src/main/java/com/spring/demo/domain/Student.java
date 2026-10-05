package com.spring.demo.domain;

import java.util.ArrayList;
import java.util.List;

//import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity 
@Table(name="student")
public class Student {
    /*
        Strategy Types
        Identity - uses the database auto-increment/identity column
        SEQUENCE - use the database sequences
        TABLE - JPA uses a table to simulate a sequence
        AUTO - JPA?provider choose the strategy automatically
    */ 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne 
    @JoinColumn (name="school_id")
    @JsonIgnore
    private School school;

    @OneToMany (
        mappedBy = "student",
        orphanRemoval = true,
        cascade = CascadeType.ALL
    )
    private List<Enrollment> enrollments = new ArrayList<>(); 

    @Size(max=20)
    @Column(name = "first_name",length = 45) //column name same as database
    private String firstName;
    @Size(max=20)
    @Column (name = "last_name",length = 45)
    private String lastName;
    /* worth being aware of
    @NotNull
    @NotBlank



     */ 
    // by default nullable is true
    @Email
    @NotBlank // this apply to java application ensure not null empty, or whitespace
    @Column (name = "email",length = 45,nullable=false,unique = true) // this apply to database level
    private String email;

    public Student() {}
    
    
    public Student(String firstName, String lastName, @Email @NotBlank String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student(String firstName, String lastName, @Email @NotBlank String email, School school ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.school = school;
    }


    public Integer getId() {
        return id;
    }
    

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        
    }
    public School getSchool(){
        return this.school;
    }
    public void setSchool(School school){
        this.school = school;
        
    }
    public List<Enrollment> getEnrollments(){
        return enrollments;
    }

    public void addEnrollment(Enrollment enrollment){
        enrollments.add(enrollment);
        enrollment.setStudent(this);
    }

    public void removeEnrollment(Enrollment enrollment){
        enrollments.remove(enrollment);
        enrollment.setStudent(null);
    }

    
    



    

}
