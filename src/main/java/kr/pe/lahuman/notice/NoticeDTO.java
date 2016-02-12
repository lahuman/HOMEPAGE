package kr.pe.lahuman.notice;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * Created by lahuman on 2016. 2. 12..
 */
public class NoticeDTO {

    private NoticeDTO(){};

    @Data
    public static class Request{
        @NotBlank
        private String title;
        @NotBlank
        private String contents;
    }

    @Data
    public static class Response{
        private Long id;
        private String contents;
        private String title;
        private Date registerDt;
        private Date modifyDt;
    }
}
