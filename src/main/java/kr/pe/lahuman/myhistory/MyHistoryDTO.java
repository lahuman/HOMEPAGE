package kr.pe.lahuman.myhistory;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by lahuman on 15. 12. 8.
 */
public class MyHistoryDTO {
    private MyHistoryDTO(){};

    @Data
    public static class Response{
        private Long id;
        private String year;
        private String startMonth;
        private String endMonth;
        private String contents;
        private Date registerDt;
        private Date modifyDt;
    }

    @Data
    public static class Request {
        @NotBlank
        @Size(min = 4, max = 4)
        private String year;
        @NotBlank
        @Size(min = 2, max = 2)
        private String startMonth;
        @NotBlank
        @Size(min = 2, max = 2)
        private String endMonth;
        @NotBlank
        private String contents;
    }
}
