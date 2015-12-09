package kr.pe.lahuman.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lahuman on 15. 12. 7.
 */
@Data
@Entity
public class MyHistory extends DefaultEntity{

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
