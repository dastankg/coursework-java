package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @Column
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_group_id")
    private Group group;


}