package com.example.demo.mapper;

import com.example.demo.dto.MeetingDto;
import com.example.demo.model.Meeting;

public class MeetingMapper {

    public static Meeting DtoToEntity(MeetingDto dto){
        Meeting meeting = new Meeting();
        meeting.setId(dto.getId());
        meeting.setName(dto.getName());
        meeting.setDate(dto.getDate());
        meeting.setAddress(dto.getAddress());
        meeting.setGroup(dto.getGroup());
        return meeting;
    }
    public static MeetingDto EntityToDto(Meeting meeting){
        MeetingDto dto = new MeetingDto();
        dto.setId(meeting.getId());
        dto.setName(meeting.getName());
        dto.setDate(meeting.getDate());
        dto.setAddress(meeting.getAddress());
        dto.setGroup(meeting.getGroup());
        return dto;
    }
}
