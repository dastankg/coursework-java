package com.example.demo.service.Impl;

import com.example.demo.dto.GroupDto;
import com.example.demo.mapper.GroupMapper;
import com.example.demo.model.Group;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GroupServiceImpl implements GroupService {
    private final UserRepository userRepository;

    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository,
                            UserRepository userRepository) {
        this.groupRepository = groupRepository;

        this.userRepository = userRepository;
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

        log.info("IN findById - group: {} found by id: {}", result);
        return result;

    }

    @Override
    public Group findByUsername(String username) {
        Group result = groupRepository.findByName(username);
        log.info("IN findByName - group: {} found by name", result, username);
        return result;
    }

    @Override
    public Group register(Group group) {
        return null;
    }


    public Group save(GroupDto dto) {
        Group group = GroupMapper.DtoToEntity(dto);
        groupRepository.save(group);
        return GroupMapper.EntityToDto(group).toGroup();
    }


//    @Override
//    public User findByUsername(String username) {
//        User result = userRepository.findByUsername(username);
//        log.info("IN findByUsername - user: {} found by username: {}", result, username);
//        return result;
//    }
}
