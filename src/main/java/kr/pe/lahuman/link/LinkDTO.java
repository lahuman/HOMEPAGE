package kr.pe.lahuman.link;

import kr.pe.lahuman.models.Link;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by lahuman on 2015. 12. 26..
 */
public class LinkDTO {
    private LinkDTO(){};

    @Data
    public static class Request{
        @NotBlank @Size(min = 2, max = 50)
        private String name;
        @NotBlank @Size(min = 5, max=1000)
        private String link;
        @NotBlank
        private Link.Code code;
    }
    @Data
    public static class Response{
        private Long id;

        private String name;
        private String link;
        private Link.Code code;
    }
}
