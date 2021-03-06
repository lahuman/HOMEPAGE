package kr.pe.lahuman.project;

import lombok.Data;

import java.util.Date;

/**
 * Created by lahuman on 15. 12. 10.
 */
public class ProjectVersionDTO {

    @Data
    public static class Response {
        private String version;
        private String updateInfo;
        public Date registerDt;
        public Date modifyDt;
    }
    @Data
    public static class Request {
        private String version;
        private String updateInfo;
    }
}
