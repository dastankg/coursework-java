package com.example.demo.rest;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
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
        StudentDto result = StudentDto.fromStudent(student);
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

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<StudentDto> getByUsername(@PathVariable(name = "name") String name){
        Student student = studentService.findByUsername(name);
        if (student == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        StudentDto result = StudentDto.fromStudent(student);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(value="/newStudent/{id}")
    ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody StudentDto dto) {
        return ResponseEntity.ok().body(studentService.update(id, dto));
    }

    @DeleteMapping(value="/deleteStudent/{id}")
    ResponseEntity<Void> deleteStudent( @PathVariable("id") Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
