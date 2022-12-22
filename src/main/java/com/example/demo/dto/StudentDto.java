package com.example.demo.dto;

import com.example.demo.model.Group;
import com.example.demo.model.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDto {
    private Long id;
    private String name;
    private String phone;
    private Group group;

    public static StudentDto fromStudent(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setPhone(student.getPhone());
        studentDto.setGroup(student.getGroup());

        return studentDto;
    }

    public Student toStudent() {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setPhone(phone);
        student.setGroup(group);
        return student;
    }
}
