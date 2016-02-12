package kr.pe.lahuman.notice;

import kr.pe.lahuman.common.Utils;
import kr.pe.lahuman.models.Notice;
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
 * Created by lahuman on 2016. 2. 12..
 */
@RestController
@RequestMapping(value = "/notice")
@Slf4j
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public PageImpl<NoticeDTO.Response> getNotice(Pageable pageable){
        Page<Notice> page = noticeService.list(pageable);
        List<NoticeDTO.Response> content = page.getContent().stream()
                .map(notice -> modelMapper.map(notice, NoticeDTO.Response.class)).collect(Collectors.toList());
        return new PageImpl<NoticeDTO.Response>(content, pageable, page.getTotalElements());
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createNotice(@RequestBody @Valid NoticeDTO.Request dto, BindingResult result){
        Utils.checkValid4JSON(result);
        return getResponseEntity(noticeService.addNotice(dto));
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity updateNotice(@NonNull @PathVariable Long id,
                                       @RequestBody @Valid NoticeDTO.Request dto, BindingResult result){
        Utils.checkValid4JSON(result);
        Notice notice = noticeService.modifyNotice(id, dto);
        return getResponseEntity(notice);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity remove(@NonNull @PathVariable Long id){
        noticeService.removeNotice(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity get(@NonNull @PathVariable Long id){
        return getResponseEntity(noticeService.getNotice(id));
    }

    private ResponseEntity getResponseEntity(Notice notice) {
        return new ResponseEntity(modelMapper.map(notice, NoticeDTO.Response.class), HttpStatus.OK);
    }
}
