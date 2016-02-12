package kr.pe.lahuman.notice;

import kr.pe.lahuman.models.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lahuman on 2016. 2. 12..
 */
public interface NoticeRepository extends JpaRepository<Notice, Long>{
}
