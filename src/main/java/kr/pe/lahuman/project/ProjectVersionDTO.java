package kr.pe.lahuman.project;

import lombok.Data;

/**
 * Created by lahuman on 15. 12. 10.
 */
public class ProjectVersionDTO {

    @Data
    public static class Response {
        private Long versionId;
        private String version;
        private String updateInfo;
    }
    @Data
    public static class Request {
        private String version;
        private String updateInfo;
    }
}
