package com.example.EPE.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String jobTitle;

}
