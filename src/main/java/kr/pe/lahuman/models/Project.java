package kr.pe.lahuman.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lahuman on 15. 12. 7.
 */
@Entity
public class Project extends DefaultEntity{
    @Id @Column(name = "PROJECT_ID")
    @GeneratedValue
    @Getter @Setter
    private Long id;

    @Column(length = 1000)
    @Getter @Setter
    private String imageFile;
    @Getter @Setter
    @Column(length = 500)
    private String name;
    @Getter @Setter
    @Column(length = 1000)
    private String projectUrl;
    @Getter @Setter
    @Column(length = 1000)
    private String file;
    @Getter @Setter
    @Column(columnDefinition = "TEXT")
    private String contents;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    @Getter @Setter
    private Set<ProjectVersion> projectVersions = new HashSet<>();

    public void addProjectVersions(ProjectVersion pv){
        this.projectVersions.add(pv);
        if(pv.getOwner() != this ){
            pv.setOwner(this);
        }
    }

}
