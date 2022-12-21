package com.example.demo.service;

import com.example.demo.dto.GroupDto;
import com.example.demo.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAll();

    Group findById(Long id);

    Group findByName(String username);

    Group save(Group dto);

    Group update(Long id, GroupDto group);

    void delete(Long id);
}
