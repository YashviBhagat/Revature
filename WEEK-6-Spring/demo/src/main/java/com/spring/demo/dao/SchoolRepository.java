package com.spring.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.demo.domain.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {
    @Query("select s from School s where s.name = :name")
    List<School> searchByName(@Param("name") String name);
}
