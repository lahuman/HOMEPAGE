package kr.pe.lahuman.comment;

import kr.pe.lahuman.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lahuman on 15. 12. 8.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
