package com.example.demo.service.Impl;

import com.example.demo.dto.GroupDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.mapper.GroupMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Group;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student register(Student student) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = studentRepository.findAll();
        log.info("IN getAll - {} group found", students.size());
        return students;
    }

    @Override
    public List<Student> findByGroupId(Long id) {
        return studentRepository.findByGroupId(id);
    }

    @Override
    public Student findByUsername(String username) {
        return null;
    }

    @Override
    public Student findById(Long id) {
        return null;
    }

    @Override
    public Student save(Student dto) {
        Student student = StudentMapper.DtoToEntity(StudentDto.fromGroup(dto));
        studentRepository.save(student);
        return StudentMapper.EntityToDto(student).toStudent();
    }

    @Override
    public void delete(Long id) {

    }
}
