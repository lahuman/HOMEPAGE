package kr.pe.lahuman.project;

import kr.pe.lahuman.common.CustomExceptions;
import kr.pe.lahuman.models.Project;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by lahuman on 15. 12. 10.
 */
@Service
public class ProjectService {
    @Autowired
    private ProjectRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    private final String SERVICE_NAME = "PROJECT";

    public Project addProject(ProjectDTO.Request dto){
        Project project = modelMapper.map(dto, Project.class);
        project.setRegisterDt(new Date());
        return repository.save(project);
    }

    public Page<Project> list(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Project getProject(Long id){
        Project project = repository.findOne(id);
        if(project == null){
            throw new CustomExceptions.JSONNotFoundException(SERVICE_NAME, id);
        }
        return project;
    }
    public Project modifyProject(Long id, ProjectDTO.Request dto){
        Project project = getProject(id);
        project.setContents(dto.getContents());
        project.setFile(dto.getFile());
        project.setImageFile(dto.getImageFile());
        project.setProjectUrl(dto.getProjectUrl());
        project.setProjectVersions(dto.getProjectVersions());
        project.setModifyDt(new Date());
        return repository.save(project);
    }
    public void removeProject(Long id){
        getProject(id);
        repository.delete(id);
    }


}
