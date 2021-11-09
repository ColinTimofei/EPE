package md.isdinternship.EPE.domain.user;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String jobTitle;

}
