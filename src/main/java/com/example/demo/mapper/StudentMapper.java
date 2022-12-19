package com.example.demo.mapper;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;

public class StudentMapper {
    public static Student DtoToEntity(StudentDto dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setPhone(dto.getPhone());
        student.setGroup(dto.getGroup());
        return student;
    }

    public static StudentDto EntityToDto(Student student) {
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setPhone(student.getPhone());
        dto.setGroup(student.getGroup());
        return dto;
    }


}