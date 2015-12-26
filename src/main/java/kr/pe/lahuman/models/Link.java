package kr.pe.lahuman.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lahuman on 2015. 12. 26..
 */
@Entity
@Data
public class Link extends DefaultEntity{
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 1000, nullable = false)
    private String link;
    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 3, nullable = false)
    private Code code;

    public enum Code{
        RCD,
        FRD,
        ETC
    }

}
