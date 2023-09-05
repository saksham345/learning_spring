package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentDAO {

    @Transactional
    void save(Student Thestudent);


    @Transactional
    Student findbyID(Integer ID);

    List<Student> findAll();

    List<Student> findByFirstName(String theFirstName);

    void update(Student theStudent);

    int updateMultipleRows(List<Student> Students);

    void delete(Integer id);

    int deleteAll();

}
