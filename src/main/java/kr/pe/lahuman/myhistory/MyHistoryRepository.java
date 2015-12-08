package kr.pe.lahuman.myhistory;

import kr.pe.lahuman.models.MyHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lahuman on 15. 12. 8.
 */
public interface MyHistoryRepository extends JpaRepository<MyHistory, Long> {
}
