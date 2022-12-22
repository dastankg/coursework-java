package com.example.demo.service;

import com.example.demo.dto.MeetingDto;
import com.example.demo.model.Group;
import com.example.demo.model.Meeting;

import java.util.List;

public interface MeetingService {
        List<Meeting> getAll();
        Meeting findById(Long id);
        Meeting save(Meeting meeting);
        Meeting update(Long id, MeetingDto meetingDto);
        void delete(Long id);
}
