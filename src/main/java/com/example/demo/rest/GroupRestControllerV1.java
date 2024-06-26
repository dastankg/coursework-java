package com.example.demo.rest;

import com.example.demo.dto.GroupDto;
import com.example.demo.model.Group;
import com.example.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/groups/")
public class GroupRestControllerV1 {

    private final GroupService groupService;

    @Autowired
    public GroupRestControllerV1(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<GroupDto> getGroupById(@PathVariable(name = "id") Long id) {
        Group group = groupService.findById(id);
        if (group == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        GroupDto result = GroupDto.fromGroup(group);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/groups/")
    public ResponseEntity<List<Group>> getAll() {
        return ResponseEntity.ok(groupService.getAll());
    }

    @PostMapping(value = "/create/")
    ResponseEntity<Group> createGroup(@RequestBody Group dto) {
        return ResponseEntity.ok().body(groupService.save(dto));
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<GroupDto> getByUsername(@PathVariable(name = "name") String name) {
        Group group = groupService.findByName(name);
        if (group == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        GroupDto result = GroupDto.fromGroup(group);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(value = "/newGroup/{id}")
    ResponseEntity<Group> updateGroup(@PathVariable("id") Long id, @RequestBody GroupDto dto) {
        return ResponseEntity.ok().body(groupService.update(id, dto));
    }

    @DeleteMapping(value = "/deleteGroup/{id}")
    ResponseEntity<Void> deleteProtocol(@PathVariable("id") Long id) {
        groupService.delete(id);
        return ResponseEntity.noContent().build();
    }
}