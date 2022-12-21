package com.example.demo.rest;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Group;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students/")
public class StudentRestControllerV1 {
    private final StudentService studentService;

    @Autowired
    public StudentRestControllerV1(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<StudentDto> getGroupById(@PathVariable(name = "id") Long id) {
        Student student = studentService.findById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        StudentDto result = StudentDto.fromGroup(student);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/students/")
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping(value = "/group/{id}")
    public ResponseEntity<List<Student>> findByGroupId(@PathVariable(name = "id") Long id){
        List<Student> students = studentService.findByGroupId(id);
        return new ResponseEntity<>(students, HttpStatus.OK);

    }

    @PostMapping(value = "/create/")
    ResponseEntity<Student> createGroup(@RequestBody Student dto) {
        return ResponseEntity.ok().body(studentService.save(dto));
    }
}
