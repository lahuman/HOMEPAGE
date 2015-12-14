package kr.pe.lahuman.project;

import kr.pe.lahuman.common.CustomExceptions;
import kr.pe.lahuman.models.Project;
import kr.pe.lahuman.models.ProjectVersion;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by lahuman on 15. 12. 10.
 */
@Service
@Transactional
public class ProjectService {
    @Autowired
    private ProjectRepository repository;

    @Autowired
    private ProjectVersionRepository versionRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final String SERVICE_NAME = "PROJECT";

    public Project addProject(ProjectDTO.Request dto){
        Project project = modelMapper.map(dto, Project.class);
        project.setRegisterDt(new Date());
//        dto.setProjectVersions(new HashSet<>());
//        dto.getProjectVersions().stream().map(m->modelMapper.map(m, ProjectVersion.class))
//                .forEach(pv -> {project.addProjectVersions(pv); pv.setOwner(project);});
        ;

        Project proResult = repository.save(project);
        project.getProjectVersions().stream().forEach(pv-> {
            pv.setOwner(proResult);
            System.out.println(proResult);
            ProjectVersion projectVersion= versionRepository.save(pv);
            System.out.println(projectVersion);
        });
        return proResult;
    }

    public Page<Project> list(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Project getProject(Long id){
        Project project = repository.findOne(id);
        if(project == null){
            throw new CustomExceptions.NotFoundException(SERVICE_NAME, id);
        }
        return project;
    }
    public Project modifyProject(Long id, ProjectDTO.Request dto){
        Project project = getProject(id);
        project.setContents(dto.getContents());
        project.setFile(dto.getFile());
        project.setImageFile(dto.getImageFile());
        project.setProjectUrl(dto.getProjectUrl());
        project.setModifyDt(new Date());

        dto.getProjectVersions().stream().map(m->modelMapper.map(m, ProjectVersion.class))
                .forEach(pv -> project.addProjectVersions(pv));
        repository.save(project);
        project.getProjectVersions().stream().forEach(pv->versionRepository.save(pv));

        return project;
    }
    public void removeProject(Long id){
        getProject(id);
        repository.delete(id);
    }


}
