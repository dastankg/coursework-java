package com.example.demo.service.Impl;

import com.example.demo.Exception.NotFoundException;
import com.example.demo.dto.MeetingDto;
import com.example.demo.mapper.MeetingMapper;
import com.example.demo.model.Meeting;
import com.example.demo.repository.MeetingRepository;
import com.example.demo.service.MeetingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class MeetingImpl implements MeetingService {


    private final MeetingRepository meetingRepository;
    @Autowired
    public MeetingImpl(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }
    @Override
    public List<Meeting> getAll() {
        List<Meeting> meetings = meetingRepository.findAll();
        log.info("IN getAll - {} group found", meetings.size());
        return meetings;
    }

    @Override
    public Meeting findById(Long id) {
        Meeting result = meetingRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("IN findById - no group r found by id: {}", id);
            return null;
        }
        log.info("IN findById - group: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public Meeting save(Meeting dto) {
        Meeting meeting = MeetingMapper.DtoToEntity(MeetingDto.fromMeeting(dto));
        meetingRepository.save(meeting);
        return MeetingMapper.EntityToDto(meeting).toMeeting();
    }

    @Override
    public Meeting update(Long id, MeetingDto meetingDto) {
        Meeting meeting = meetingRepository.findById(id).orElseThrow(() -> new NotFoundException("No Student with ID : " + id));
        Meeting newMeeting = MeetingMapper.DtoToEntity(meetingDto);
        newMeeting.setId(meeting.getId());
        return MeetingMapper.EntityToDto(meetingRepository.save(newMeeting)).toMeeting();
    }

    @Override
    public void delete(Long id) {
        Meeting meeting = meetingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No Student with ID : " + id));
        meetingRepository.delete(meeting);
    }
}
