package com.example.EPE.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @JoinColumn(name = "job_id")
    @ManyToOne
    private Job job;

    @Column(name = "overall_score")
    private Float overallScore;

    @ManyToOne
    private AssessmentStatus status;

    @Column
    private Boolean isTemplate;

    @Column
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date startDate;

    @Column
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date endDate;

    @OneToMany(
            mappedBy = "assessment",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<EvaluationGroup> evaluationGroups = new ArrayList<>();

    @OneToMany(
            mappedBy = "assessment",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<PersonalGoal> personalGoals = new ArrayList<>();

    @OneToMany(
            mappedBy = "assessment",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<DepartmentGoal> departmentGoals = new ArrayList<>();

    @OneToMany(
            mappedBy = "assessment",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Feedback> feedbacks = new ArrayList<>();

}
