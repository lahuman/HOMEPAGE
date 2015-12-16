package kr.pe.lahuman.comment;

import kr.pe.lahuman.models.Comment;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lahuman on 15. 12. 15.
 */
public class CommentDTO {
    private CommentDTO(){};

    @Data
    public static class Request{
        @NotBlank @Size(min = 2, max = 40)
        private String name;
        private Comment.Code code;
        private Long codeId;
        private String ip;
        @NotBlank @Size(min = 5, max = 4000)
        private String comment;
        private Long mainId;
    }

    @Data
    public static class Response{
        private Long id;
        private String name;
        private Comment.Code code;
        private Long codeId;
        private String ip;
        private String comment;
        private Set<CommentDTO.Response> subComment = new HashSet<>();
    }

}
