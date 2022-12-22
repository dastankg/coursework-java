package com.example.demo.rest;

import com.example.demo.dto.MeetingDto;
import com.example.demo.model.Meeting;
import com.example.demo.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/meeting/")
public class MeetingRestControllerV1 {
    private final MeetingService meetingService;
    @Autowired
    public MeetingRestControllerV1(MeetingService meetingService) {
        this.meetingService = meetingService;
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<MeetingDto> getGroupById(@PathVariable(name = "id") Long id) {
        Meeting meeting = meetingService.findById(id);
        if (meeting == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        MeetingDto result = MeetingDto.fromMeeting(meeting);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping(value = "/meeting/")
    public ResponseEntity<List<Meeting>> getAll() {
        return ResponseEntity.ok(meetingService.getAll());
    }

    @PostMapping(value = "/create/")
    ResponseEntity<Meeting> createMeeting(@RequestBody Meeting dto) {
        return ResponseEntity.ok().body(meetingService.save(dto));
    }


    @PutMapping(value = "/new/{id}")
    ResponseEntity<Meeting> updateMeeting(@PathVariable("id") Long id, @RequestBody MeetingDto dto) {
        return ResponseEntity.ok().body(meetingService.update(id, dto));
    }

    @DeleteMapping(value = "/deleteGroup/{id}")
    ResponseEntity<Void> deleteProtocol(@PathVariable("id") Long id) {
        meetingService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
