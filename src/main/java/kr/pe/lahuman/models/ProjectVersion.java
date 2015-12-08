package kr.pe.lahuman.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by lahuman on 15. 12. 7.
 */
@Entity
@Data
public class ProjectVersion extends DefaultEntity {
    @Id
    @Column(name = "VERSION_ID", nullable = false)
    private Long id;

    private String version;
    @Column(length = 1000)
    private String updateInfo;

}
