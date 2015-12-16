package kr.pe.lahuman.comment;

import kr.pe.lahuman.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lahuman on 15. 12. 8.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByCode(Comment.Code code);
    List<Comment> findByCodeAndCodeId(Comment.Code code, Long codeId);
}
