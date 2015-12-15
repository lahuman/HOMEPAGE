package kr.pe.lahuman.singlephase;

import kr.pe.lahuman.common.Utils;
import kr.pe.lahuman.models.SinglePhase;
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
 * Created by lahuman on 15. 12. 15.
 */
@RestController
@RequestMapping(value = "/singlephase")
public class SinglePhaseController {
    @Autowired
    private SinglePhaseService singlePhaseService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public PageImpl<SinglePhaseDTO> list(Pageable pageable){
        Page<SinglePhase> page = singlePhaseService.list(pageable);
        List<SinglePhaseDTO> content = page.getContent().stream()
                .map(sp->modelMapper.map(sp, SinglePhaseDTO.class))
                .collect(Collectors.toList());
        return new PageImpl<SinglePhaseDTO>(content, pageable, page.getTotalElements());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public SinglePhaseDTO get(@NonNull @PathVariable Long id){
        return modelMapper.map(singlePhaseService.get(id), SinglePhaseDTO.class);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public SinglePhaseDTO add(@RequestBody @Valid SinglePhaseDTO singlePhaseDTO, BindingResult result){
        Utils.checkValid4JSON(result);
        return modelMapper.map(singlePhaseService.add(singlePhaseDTO), SinglePhaseDTO.class);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public SinglePhaseDTO modify(@NonNull @PathVariable Long id, @Valid @RequestBody SinglePhaseDTO singlePhaseDTO, BindingResult result){
        Utils.checkValid4JSON(result);
        return modelMapper.map(singlePhaseService.modify(id, singlePhaseDTO), SinglePhaseDTO.class);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@NonNull @PathVariable Long id){
        singlePhaseService.get(id);
        singlePhaseService.remove(id);
    }

}
