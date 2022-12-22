package com.example.demo.service.Impl;

import com.example.demo.Exception.NotFoundException;
import com.example.demo.dto.StudentDto;
import com.example.demo.mapper.StudentMapper;
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
        Student result = studentRepository.findByName(username);
        log.info("IN findByName - student: {} found by name {}", result, username);
        return result;
    }

    @Override
    public Student findById(Long id) {
        return null;
    }

    @Override
    public Student save(Student dto) {
        Student student = StudentMapper.DtoToEntity(StudentDto.fromStudent(dto));
        studentRepository.save(student);
        return StudentMapper.EntityToDto(student).toStudent();
    }

    @Override
    public Student update(Long id, StudentDto dto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("No Student with ID : " + id));
        Student newStudent = StudentMapper.DtoToEntity(dto);
        newStudent.setId(student.getId());
        return StudentMapper.EntityToDto(studentRepository.save(newStudent)).toStudent();
    }

    @Override
    public void delete(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No Student with ID : " + id));
        studentRepository.delete(student);

    }
}
