package md.internship.EPE.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "image")
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
