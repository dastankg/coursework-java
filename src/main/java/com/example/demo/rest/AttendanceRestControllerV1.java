package com.example.demo.rest;

import com.example.demo.dto.AttendanceDto;
import com.example.demo.dto.AttendanceDto1;
import com.example.demo.model.Attendance;
import com.example.demo.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/attendance/")
public class AttendanceRestControllerV1 {
    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceRestControllerV1(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AttendanceDto> getAttendanceById(@PathVariable(name = "id") Long id) {
        Attendance attendance = attendanceService.findById(id);
        if (attendance == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        AttendanceDto result = AttendanceDto1.fromAttendance(attendance);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping(value = "date{date}")
    public ResponseEntity<AttendanceDto> getAttendanceByDate(@PathVariable(name = "date")Date date) {
        Attendance attendance = attendanceService.findByDate(date);
        if (attendance == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        AttendanceDto result = AttendanceDto1.fromAttendance(attendance);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping(value = "/attendance/")
    public ResponseEntity<List<AttendanceDto1>> getAll() {
        return ResponseEntity.ok(attendanceService.getAll());
    }
    @GetMapping(value = "/protocol/{id}")
    public ResponseEntity<List<Attendance>> getAttendanceByDate(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(attendanceService.findByProtocolId(id));
    }

    @PostMapping(value = "/create/")
    ResponseEntity<Attendance> createGroup(@RequestBody Attendance dto) {
        return ResponseEntity.ok().body(attendanceService.save(dto));
    }

    @PutMapping(value = "/update/{id}")
    ResponseEntity<Attendance> updateAttendance(@PathVariable("id") Long id, @RequestBody AttendanceDto dto) {
        return ResponseEntity.ok().body(attendanceService.update(id, dto));
    }

    @DeleteMapping(value = "/delete/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        attendanceService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
