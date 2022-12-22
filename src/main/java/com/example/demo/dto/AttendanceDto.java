package com.example.demo.dto;

import com.example.demo.model.Attendance;
import com.example.demo.model.Protocol;
import lombok.Data;

import java.util.Date;

@Data

public class AttendanceDto {

    private Long id;
    private String name;
    private String status;
    private Protocol protocol;
    private Date date;

    public static AttendanceDto fromAttendance(Attendance attendance) {
        AttendanceDto attendanceDto = new AttendanceDto();
        attendanceDto.setId(attendance.getId());
        attendanceDto.setName(attendance.getName());
        attendanceDto.setStatus(attendance.getStatus());
        attendanceDto.setDate(attendance.getDate());
        attendanceDto.setProtocol(attendance.getProtocol());
        return attendanceDto;
    }

    public Attendance toAttendance() {
        Attendance attendance = new Attendance();
        attendance.setId(id);
        attendance.setName(name);
        attendance.setStatus(status);
        attendance.setDate(date);
        attendance.setProtocol(protocol);
        return attendance;
    }
}
