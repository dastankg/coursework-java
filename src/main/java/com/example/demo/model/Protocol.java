package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;


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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkGroupid")
    private Group group;
}
