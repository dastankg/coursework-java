package com.example.demo.repository;

import com.example.demo.dto.AttendanceDto1;
import com.example.demo.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Attendance findByDate(Date date);
    List<Attendance> findByProtocolId(Long id);
}
