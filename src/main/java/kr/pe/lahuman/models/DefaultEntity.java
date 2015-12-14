package kr.pe.lahuman.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by lahuman on 15. 12. 7.
 */
@MappedSuperclass
@Getter @Setter
public abstract class DefaultEntity  implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDt;

}
