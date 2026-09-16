package com.cleancode.api;
import java.util.Scanner;

import com.cleancode.service.*;
import com.cleancode.domain.*;

public class StudentRepl {

    private final Scanner scanner = new Scanner(System.in);
    private final StudentService studentService;
    public StudentRepl(StudentService svc){
    this.studentService = svc;
}

    // Flow of the user input 
    public void run(){
        // This loop is running till we terminate
        while(true){  
            System.out.println(">"); 
            String command = scanner.nextLine().trim();

            if(command.equals("exit")){
                return ;
            }
            try{
                handle(command);

            }catch(IllegalArgumentException e){
                System.out.println("Error:" + e.getMessage());
            }
        }
    }
   private void handle(String command){
    switch (command) {
        case "help" -> printHelp();
        case "add" -> studentService.addStudent(readStudent()); 
        case "list" -> studentService.findAllStudents().forEach(System.out::println);
        case "find" -> findStudent();

    }


   } 
   private void findStudent(){
    System.out.println("Student ID:");
    int id = Integer.parseInt(scanner.nextLine().trim());
    Student s = studentService.findStudent(id);
    if(s == null){
        System.out.println("Student not found");
        return;
    }
    else{
        System.out.println(s);
    }
   }
   

    private Student readStudent(){
        System.out.println("Student ID:");
        int id = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Name: ");
        String name = scanner.nextLine().trim();
        System.out.println("Major: ");
        String major = scanner.nextLine().trim();
        System.out.println("GPA: ");
        double gpa = Double.parseDouble(scanner.nextLine().trim());
        return new Student(id,name,major,gpa);
        

   }
   private void printHelp(){
        System.out.println("Available Commands:");
        System.out.println("exit - Exit the application");
        System.out.println("add - Add a new Student");
        System.out.println("list - List of all Student");
        System.out.println("find - Find a student by ID");
   }
}
