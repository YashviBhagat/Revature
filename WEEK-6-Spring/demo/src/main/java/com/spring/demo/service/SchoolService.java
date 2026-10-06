package com.spring.demo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.demo.dao.SchoolRepository;
import com.spring.demo.exceptions.RecordNotFoundException;
import com.spring.demo.domain.School;


@Service 
public class SchoolService {
    private final SchoolRepository schoolRepo;

    public SchoolService(SchoolRepository schoolRepository){
        this.schoolRepo = schoolRepository;
    }

    @Transactional(readOnly = true)
    public School getSchoolById(int id){
        return schoolRepo.findById(id)
            .orElseThrow(() ->
                new RecordNotFoundException("School not found with id: "+ id));
    }

    @Transactional (readOnly = true)
    public List<School> getAllSchools(Pageable pageable){
        return schoolRepo.findAll(pageable).getContent();
    }

    @Transactional 
    public School insertSchool(School school){
        return schoolRepo.save(school);
    }


}
