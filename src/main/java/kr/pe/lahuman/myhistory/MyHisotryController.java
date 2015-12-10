package kr.pe.lahuman.myhistory;

import kr.pe.lahuman.common.Utils;
import kr.pe.lahuman.models.MyHistory;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lahuman on 15. 12. 8.
 */
@RestController
@RequestMapping(value = "/myhistory")
@Slf4j
public class MyHisotryController {
    @Autowired
    private MyHistoryService myHistoryService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public PageImpl<MyHistoryDTO.Response> getMyHistory(Pageable pageable){
        Page<MyHistory> page = myHistoryService.list(pageable);
        List<MyHistoryDTO.Response> content = page.getContent().stream()
                .map(myHistory -> modelMapper.map(myHistory, MyHistoryDTO.Response.class)).collect(Collectors.toList());
        return new PageImpl<MyHistoryDTO.Response>(content, pageable, page.getTotalElements());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createMyHistory(@RequestBody @Valid MyHistoryDTO.Create dto, BindingResult result){
        Utils.checkValid4JSON(result);
        MyHistory myHistory = myHistoryService.addMyHistory(dto);
        return getResponseEntity(myHistory);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity updateMyHistory(@NonNull @PathVariable Long id,
                                          @RequestBody @Valid MyHistoryDTO.Update dto, BindingResult result){
        Utils.checkValid4JSON(result);
        MyHistory myHistory = myHistoryService.modifyMyHistory(id, dto);
        return getResponseEntity(myHistory);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity remove(@NonNull @PathVariable Long id){
        myHistoryService.removeMyHistory(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity get(@NonNull @PathVariable Long id){
        return getResponseEntity(myHistoryService.getMyHistory(id));
    }


    private ResponseEntity getResponseEntity(MyHistory myHistory) {
        return new ResponseEntity(modelMapper.map(myHistory, MyHistoryDTO.Response.class), HttpStatus.OK);
    }
}
