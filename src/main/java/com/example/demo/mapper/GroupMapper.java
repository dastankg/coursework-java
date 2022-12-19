package com.example.demo.mapper;

import com.example.demo.dto.GroupDto;
import com.example.demo.model.Group;

public class GroupMapper {
    public static Group DtoToEntity(GroupDto dto) {
        Group group = new Group();
        group.setId(dto.getId());
        group.setName(dto.getName());
        return group;
    }

    public static GroupDto EntityToDto(Group entity) {
        GroupDto dto = new GroupDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }


}