package kr.pe.lahuman.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lahuman on 15. 12. 7.
 */
@Data
@Entity
public class MyHistory extends DefaultEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 4, nullable = false)
    private String year;
    @Column(length = 2, nullable = false)
    private String startMonth;
    @Column(length = 2, nullable = false)
    private String endMonth;
    @Column(length = 4000, nullable = false)
    private String contents;

}
