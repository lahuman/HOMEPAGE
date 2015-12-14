package kr.pe.lahuman.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lahuman on 15. 12. 7.
 */
@Entity
public class ProjectVersion extends DefaultEntity{
    @Id @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    @Getter
    private Project owner;

    @Getter @Setter
    private String version;
    @Column(length = 1000)
    @Getter @Setter
    private String updateInfo;

    public void setOwner(Project owner){
        this.owner = owner;
        if(!owner.getProjectVersions().contains(this)){
            owner.getProjectVersions().add(this);
        }
    }

}
