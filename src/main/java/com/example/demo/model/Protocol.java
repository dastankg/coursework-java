package com.example.demo.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "protocol")
@Data
public class Protocol {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "agendas", nullable = false)
    private String agendas;
    @Column(name = "hearing", nullable = false)
    private String hearing;
    @Column(name = "decided", nullable = false)
    private String decided;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fkMeeting")
    private Meeting meeting;

}
