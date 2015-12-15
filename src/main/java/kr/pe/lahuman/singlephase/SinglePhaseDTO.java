package kr.pe.lahuman.singlephase;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by lahuman on 15. 12. 15.
 */
@Data
public class SinglePhaseDTO {

    @NotBlank
    @Size(min = 10, max = 4000)
    public String contents;
    public Date registerDt;
    public Date modifyDt;
}
