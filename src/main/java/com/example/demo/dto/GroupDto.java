package com.example.demo.dto;

import com.example.demo.model.BaseEntity;
import com.example.demo.model.Group;
import com.example.demo.model.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

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
