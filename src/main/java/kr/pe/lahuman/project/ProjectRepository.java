package kr.pe.lahuman.project;

import kr.pe.lahuman.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lahuman on 15. 12. 8.
 */
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
