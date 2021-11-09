package com.example.EPE.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Image {

    @Id
    @JoinColumn
    private Long id;

    @Lob
    @Column(columnDefinition = "bytea")
    private byte[] imageBytes;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

}
