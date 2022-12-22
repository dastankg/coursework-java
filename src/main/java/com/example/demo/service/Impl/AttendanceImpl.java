package com.example.demo.service.Impl;

import com.example.demo.Exception.NotFoundException;
import com.example.demo.dto.AttendanceDto;
import com.example.demo.dto.AttendanceDto1;
import com.example.demo.mapper.AttendanceMapper;
import com.example.demo.mapper.AttendanceMapper1;
import com.example.demo.model.Attendance;
import com.example.demo.model.Student;
import com.example.demo.repository.AttendanceRepository;
import com.example.demo.service.AttendanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class AttendanceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public List<AttendanceDto1> getAll() {
        List<Attendance> list = attendanceRepository.findAll();
        List<AttendanceDto1> listDto = new ArrayList<>();
        for(Attendance entity : list ){
            listDto.add(AttendanceMapper1.EntityToDto(entity));
        }
        return listDto;
    }

    @Override
    public Attendance findById(Long id) {
        Attendance result = attendanceRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("IN findById - no group r found by id: {}", id);
            return null;
        }
        log.info("IN findById - group: {} found by id: {}", result, id);
        return result;

    }
    @Override
    public Attendance save(Attendance dto) {
        Attendance attendance = AttendanceMapper.DtoToEntity(AttendanceDto.fromAttendance(dto));
        attendanceRepository.save(attendance);
        return AttendanceMapper.EntityToDto(attendance).toAttendance();
    }

    @Override
    public Attendance update(Long id, AttendanceDto dto) {
        Attendance attendance = attendanceRepository.findById(id).orElseThrow(() -> new NotFoundException("No Student with ID : " + id));
        Attendance newAttendance = AttendanceMapper.DtoToEntity(dto);
        newAttendance.setId(attendance.getId());
        return AttendanceMapper.EntityToDto(attendanceRepository.save(newAttendance)).toAttendance();
    }

    @Override
    public Attendance findByDate(Date date) {
        return attendanceRepository.findByDate(date);
    }

    @Override
    public List<Attendance> findByProtocolId(Long id) {
        List<Attendance> students = attendanceRepository.findByProtocolId(id);
        log.info("IN getAll - {} group found", students.size());
        return students;
    }

    @Override
    public void delete(Long id) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No Student with ID : " + id));
        attendanceRepository.delete(attendance);
    }
}
