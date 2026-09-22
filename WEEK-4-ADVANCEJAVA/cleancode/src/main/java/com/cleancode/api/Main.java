package com.cleancode.api;

import com.cleancode.persistance.StudentDAO;
import com.cleancode.persistance.StudentDAOimpl;
import com.cleancode.service.StudentService;
import com.cleancode.service.StudentServiceImp;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAOimpl();
        StudentService service = new StudentServiceImp(dao);
        new StudentRepl(service).run();
    }
}