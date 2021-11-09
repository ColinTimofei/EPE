package com.example.EPE.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class EvaluationField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "evaluation_group_id")
    private EvaluationGroup evaluationGroup;

    @Column(nullable = false)
    private Integer value;

}
