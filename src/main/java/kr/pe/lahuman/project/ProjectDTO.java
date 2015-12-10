package kr.pe.lahuman.project;

import kr.pe.lahuman.models.ProjectVersion;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lahuman on 15. 12. 10.
 */
public class ProjectDTO {
    private ProjectDTO(){}

    @Data
    public static class Response{
        private String imageFile;
        private String name;
        private String projectUrl;
        private String file;
        private String contents;
        private Set<ProjectVersion> projectVersions = new HashSet<>();
        private Date registerDt;
        private Date modifyDt;
    }

    @Data
    public static class Request {
        private String imageFile;
        @NotBlank @Size(min = 3, max = 500)
        private String name;
        private String projectUrl;
        private String file;
        @NotBlank @Size(min = 10, max = 4000)
        private String contents;
        private Set<ProjectVersion> projectVersions = new HashSet<>();
    }
}
