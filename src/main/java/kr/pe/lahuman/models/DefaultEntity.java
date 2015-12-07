package kr.pe.lahuman.models;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by lahuman on 15. 12. 7.
 */
public class DefaultEntity {

    @Temporal(TemporalType.TIMESTAMP)
    private Date regist_dt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modify_dt;

}
