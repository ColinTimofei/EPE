package com.example.EPE.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table("assessment_statuses")
public class AssessmentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String status;

}
