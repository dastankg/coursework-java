package com.example.demo.service;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();
    List<Student> findByGroupId(Long id);

    Student findByUsername(String username);

    Student findById(Long id);
    Student save(Student dto);

    Student update(Long id, StudentDto student);
    void delete(Long id);
}
