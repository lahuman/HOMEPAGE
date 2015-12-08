package kr.pe.lahuman.myhistory;

import lombok.Data;

import java.util.Date;

/**
 * Created by lahuman on 15. 12. 8.
 */
public class MyHistoryDTO {
    @Data
    public static class Response{
        private Long id;
        private String year;
        private String startMonth;
        private String endMonth;
        private String contents;
        private Date regist_dt;
        private Date modify_dt;
    }

    @Data
    public static class Create{
        private String year;
        private String startMonth;
        private String endMonth;
        private String contents;
    }

}
