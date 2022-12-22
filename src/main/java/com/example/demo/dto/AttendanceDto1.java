package com.example.demo.dto;

import com.example.demo.model.Attendance;
import com.example.demo.model.Protocol;
import lombok.Data;

import java.util.Date;

@Data

public class AttendanceDto1 {

    private Long id;
    private String name;
    private String status;
    private Date date;

    public static AttendanceDto fromAttendance(Attendance attendance) {
        AttendanceDto attendanceDto1 = new AttendanceDto();
        attendanceDto1.setId(attendance.getId());
        attendanceDto1.setName(attendance.getName());
        attendanceDto1.setStatus(attendance.getStatus());
        attendanceDto1.setDate(attendance.getDate());
        return attendanceDto1;
    }

    public Attendance toAttendance() {
        Attendance attendance = new Attendance();
        attendance.setId(id);
        attendance.setName(name);
        attendance.setStatus(status);
        attendance.setDate(date);
        return attendance;
    }
}
