package com.example.demo.mapper;

import com.example.demo.dto.AttendanceDto;
import com.example.demo.dto.AttendanceDto1;
import com.example.demo.model.Attendance;

public class AttendanceMapper1 {
    public static Attendance DtoToEntity(AttendanceDto1 dto) {
        Attendance attendance = new Attendance();
        attendance.setId(dto.getId());
        attendance.setName(dto.getName());
        attendance.setDate(dto.getDate());
        attendance.setStatus(dto.getStatus());
        return attendance;


    }

    public static AttendanceDto1 EntityToDto(Attendance entity) {
        AttendanceDto1 dto = new AttendanceDto1();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        dto.setDate(entity.getDate());
        return dto;
    }
}