package kr.pe.lahuman.project;

import kr.pe.lahuman.models.Project;
import kr.pe.lahuman.models.ProjectVersion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lahuman on 15. 12. 14.
 */
public interface ProjectVersionRepository extends JpaRepository<ProjectVersion, Long> {
    List<ProjectVersion> findByOwnerId(Long id);

    Long deleteByOwner(Project project);
}
