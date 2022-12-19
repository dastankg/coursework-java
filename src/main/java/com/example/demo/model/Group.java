package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "groupStudents")
@Data
public class Group extends BaseEntity {
    @Id
    @Column(name = "group_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

}
