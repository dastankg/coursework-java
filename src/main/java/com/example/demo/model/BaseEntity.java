package com.example.demo.model;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    @Column(name = "created", nullable = true)
    private Date created;
    @LastModifiedDate
    @Column(name = "updated", nullable = true)
    private Date updated;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

}
