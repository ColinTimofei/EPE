package com.example.EPE.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table("users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, updatable = false)
    private String email;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(name = "birth_date", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthDate;

    @Column(name = "employment_date", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date employmentDate;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_id")
    private Job job;

    @Column(columnDefinition = "text")
    private String bio;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @PrimaryKeyJoinColumn
    private Image photo;

    @Column(nullable = false)
    private String password;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "user",
            orphanRemoval = true
    )
    List<Assessment> assessments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "team_leader_id")
    private Long teamLeaderId;

    @Column(name = "buddy_id")
    private Long buddyId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthDate=" + birthDate +
                ", employmentDate=" + employmentDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", job=" + job +
                ", bio='" + bio + '\'' +
                ", photo=" + photo +
                ", password='" + password + '\'' +
                ", assessments=" + assessments.stream().map(Assessment::getId).collect(Collectors.toList()) +
                ", role=" + role +
                ", teamLeaderId=" + teamLeaderId +
                ", buddyId=" + buddyId +
                '}';
    }
}