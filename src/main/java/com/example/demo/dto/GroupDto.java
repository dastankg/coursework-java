package com.example.demo.dto;


import com.example.demo.model.Group;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupDto {
    private Long id;
    private String name;

    public static GroupDto fromGroup(Group group) {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setName(group.getName());
        return groupDto;
    }

    public Group toGroup() {
        Group group = new Group();
        group.setId(id);
        group.setName(name);
        return group;
    }
}
