package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {
    Student register(Student student);

    List<Student> getAll();

    Student findByUsername(String username);

    Student findById(Long id);

    void delete(Long id);
}
