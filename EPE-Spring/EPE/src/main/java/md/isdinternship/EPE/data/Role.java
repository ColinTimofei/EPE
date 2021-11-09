package md.isdinternship.EPE.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleId;
    @Column
    private String roleName;

    public Role(String roleName){
        this.roleName = roleName;
    }

    public Role() {

    }
}
