package com.example.demo.service.Impl;

import com.example.demo.Exception.NotFoundException;
import com.example.demo.dto.GroupDto;
import com.example.demo.mapper.GroupMapper;
import com.example.demo.model.Group;
import com.example.demo.repository.GroupRepository;
import com.example.demo.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;

    }

    @Override
    public List<Group> getAll() {
        List<Group> groups = groupRepository.findAll();
        log.info("IN getAll - {} group found", groups.size());
        return groups;
    }

    @Override
    public Group findById(Long id) {
        Group result = groupRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("IN findById - no group r found by id: {}", id);
            return null;
        }
        log.info("IN findById - group: {} found by id: {}", result, id);
        return result;

    }

    @Override
    public Group findByName(String username) {
        Group result = groupRepository.findByName(username);
        log.info("IN findByName - group: {} found by name {}", result, username);
        return result;
    }

    @Override
    public Group save(Group dto) {
        Group group = GroupMapper.DtoToEntity(GroupDto.fromGroup(dto));
        groupRepository.save(group);
        return GroupMapper.EntityToDto(group).toGroup();
    }

    @Override
    public Group update(Long id, GroupDto dto) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new NotFoundException("No Student with ID : " + id));
        Group newGroup = GroupMapper.DtoToEntity(dto);
        newGroup.setId(group.getId());
        return GroupMapper.EntityToDto(groupRepository.save(newGroup)).toGroup();
    }

    @Override
    public void delete(Long id) {

        Group doctor = groupRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No Student with ID : " + id));
        groupRepository.delete(doctor);

    }
}
