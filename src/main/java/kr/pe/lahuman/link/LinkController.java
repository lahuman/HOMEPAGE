package kr.pe.lahuman.link;

import kr.pe.lahuman.common.Utils;
import kr.pe.lahuman.models.Link;
import lombok.NonNull;
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
 * Created by lahuman on 15. 12. 28.
 */
@RestController
@RequestMapping(value = "/link")
public class LinkController {
    @Autowired
    private LinkService linkService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public PageImpl<LinkDTO.Response> list(Pageable pageable){
        Page<Link> page = linkService.list(pageable);
        List<LinkDTO.Response> content = page.getContent().stream().map(map->modelMapper.map(map, LinkDTO.Response.class))
                .collect(Collectors.toList());
        return new PageImpl<LinkDTO.Response>(content, pageable, page.getTotalElements());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public LinkDTO.Response add(@Valid @RequestBody LinkDTO.Request dto, BindingResult result){
        Utils.checkValid4JSON(result);
        return modelMapper.map(linkService.add(dto), LinkDTO.Response.class);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public LinkDTO.Response modify(@NonNull @PathVariable Long id, @Valid @RequestBody LinkDTO.Request dto, BindingResult result){
        Utils.checkValid4JSON(result);
        return modelMapper.map(linkService.modify(id, dto), LinkDTO.Response.class);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@NonNull @PathVariable Long id){
        linkService.remove(id);
    }


}
