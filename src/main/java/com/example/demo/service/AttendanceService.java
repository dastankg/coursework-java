package com.example.demo.service;

import com.example.demo.dto.AttendanceDto;
import com.example.demo.dto.AttendanceDto1;
import com.example.demo.model.Attendance;

import java.util.Date;
import java.util.List;

public interface AttendanceService {
    List<AttendanceDto1> getAll();

    Attendance findById(Long id);

    Attendance save(Attendance dto);

    Attendance update(Long id, AttendanceDto dto);
    Attendance findByDate(Date date);
    List<Attendance> findByProtocolId(Long id);

    void delete(Long id);
}
