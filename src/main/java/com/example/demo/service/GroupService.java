package com.example.demo.service;

import com.example.demo.dto.GroupDto;
import com.example.demo.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAll();

    Group findById(Long id);
    Group findByUsername(String username);

    Group register(Group group);

    Group save(GroupDto dto);
}
