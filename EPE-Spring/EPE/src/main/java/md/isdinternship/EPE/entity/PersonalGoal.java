package com.example.EPE.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PersonalGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "assessment_id")
    private Assessment assessment;

    @Column(name = "context", nullable = false)
    private String context;
}
