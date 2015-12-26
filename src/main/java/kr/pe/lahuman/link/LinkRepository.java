package kr.pe.lahuman.link;

import kr.pe.lahuman.models.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lahuman on 2015. 12. 26..
 */
public interface LinkRepository extends JpaRepository<Link, Long> {
    List<Link> findByCode(Link.Code code);
}
