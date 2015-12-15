package kr.pe.lahuman.project;

import kr.pe.lahuman.common.Utils;
import kr.pe.lahuman.models.Project;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lahuman on 15. 12. 10.
 */
@RestController
@RequestMapping(value = "/project")
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectService service;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public PageImpl<ProjectDTO.Response> list(Pageable pageable){
        Page<Project> page = service.list(pageable);
        List<ProjectDTO.Response> contents = page.getContent().stream()
                .map(map->modelMapper.map(map, ProjectDTO.Response.class))
                .collect(Collectors.toList());
        return new PageImpl<ProjectDTO.Response>(contents, pageable, page.getTotalElements());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ProjectDTO.Response add(@Valid @RequestBody ProjectDTO.Request dto, BindingResult result){
        Utils.checkValid4JSON(result);
        return modelMapper.map(service.addProject(dto), ProjectDTO.Response.class);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public ProjectDTO.Response update(@NonNull @PathVariable Long id, @RequestBody @Valid ProjectDTO.Request dto, BindingResult result){
        Utils.checkValid4JSON(result);
        return modelMapper.map(service.modifyProject(id, dto), ProjectDTO.Response.class);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ProjectDTO.Response get(@NonNull @PathVariable Long id){
        return modelMapper.map(service.getProject(id), ProjectDTO.Response.class);
    }


    @RequestMapping(value= "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@NonNull @PathVariable Long id){
        service.getProject(id);
        service.removeProject(id);
    }
}
