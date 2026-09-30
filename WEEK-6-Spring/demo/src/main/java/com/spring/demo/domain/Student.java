package com.spring.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

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

    @Column(name = "first_name",length = 45) //column name same as database
    private String firstName;

    @Column (name = "last_name",length = 45)
    private String lastName;
    /* worth being aware of
    @NotNull
    @NotBlank



     */ 
    // by default nullable is true
    @Email
    @NotBlank // this apply to java application ensure not null empty, or whitespace
    @Column (name = "email",length = 45,nullable=false) // this apply to database level
    private String email;

    public Student() {}
    
    
    public Student(String firstName, String lastName, @Email @NotBlank String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id){
        this.id = id;
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
    



    

}
