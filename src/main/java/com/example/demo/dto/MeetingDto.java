package com.example.demo.dto;

import com.example.demo.model.Group;
import com.example.demo.model.Meeting;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeetingDto {
    private Long id;
    private String name;
    private Date date;
    private String address;
    private Group group;
    public static MeetingDto fromMeeting(Meeting meeting) {
        MeetingDto meetingDto = new MeetingDto();
        meetingDto.setId(meeting.getId());
        meetingDto.setName(meeting.getName());
        meetingDto.setDate(meeting.getDate());
        meetingDto.setAddress(meeting.getAddress());
        meetingDto.setGroup(meeting.getGroup());
        return meetingDto;
    }
    public Meeting toMeeting() {
        Meeting meeting = new Meeting();
        meeting.setId(id);
        meeting.setName(name);
        meeting.setDate(date);
        meeting.setAddress(address);
        meeting.setGroup(group);
        return meeting;
    }
}
