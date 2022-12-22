package com.example.demo.mapper;

import com.example.demo.dto.AttendanceDto;
import com.example.demo.model.Attendance;

public class AttendanceMapper {
    public static Attendance DtoToEntity(AttendanceDto dto) {
        Attendance attendance = new Attendance();
        attendance.setId(dto.getId());
        attendance.setName(dto.getName());
        attendance.setDate(dto.getDate());
        attendance.setStatus(dto.getStatus());
        attendance.setProtocol(dto.getProtocol());
        return attendance;


    }

    public static AttendanceDto EntityToDto(Attendance entity) {
        AttendanceDto dto = new AttendanceDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        dto.setDate(entity.getDate());
        dto.setProtocol(dto.getProtocol());
        return dto;
    }
}
