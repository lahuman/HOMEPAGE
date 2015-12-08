package kr.pe.lahuman.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lahuman on 15. 12. 7.
 */
@Entity
@Data
public class Project extends DefaultEntity{
    @Id @Column(name = "PROJECT_ID")
    @GeneratedValue
    private Long id;

    @Column(length = 1000)
    private String imageFile;
    @Column(length = 500)
    private String name;
    @Column(length = 1000)
    private String projectUrl;
    @Column(length = 1000)
    private String file;
    @Column(length = 4000)
    private String contents;

    @OneToMany
    @JoinColumn(name = "VERSION_ID", referencedColumnName = "PROJECT_ID")
    private Set<ProjectVersion> projectVersions = new HashSet<>();

}
