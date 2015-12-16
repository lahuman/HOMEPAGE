package kr.pe.lahuman.comment;

import kr.pe.lahuman.common.Utils;
import kr.pe.lahuman.models.Comment;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by lahuman on 15. 12. 16.
 */
@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "{code}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public CommentDTO.Response commentList(@NonNull @PathVariable Comment.Code code, @RequestParam(value = "codeId", required = false) Long codeId){
        return modelMapper.map((codeId == null)?commentService.listByCode(code):commentService.listByCodeAndCodeId(code, codeId), CommentDTO.Response.class);
    }

    @RequestMapping(value = "{code}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public CommentDTO.Response addComment(@NonNull @PathVariable Comment.Code code, @RequestParam(value = "codeId", required = false) Long codeId,
                                          @RequestBody @Valid CommentDTO.Request dto, BindingResult result,
                                          HttpServletRequest request){
        Utils.checkValid4JSON(result);
        dto.setIp(request.getRemoteAddr());
        dto.setCode(code);
        dto.setCodeId(codeId);
        return modelMapper.map(commentService.add(dto), CommentDTO.Response.class);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public CommentDTO.Response addComment(@NonNull @PathVariable Long id, @RequestBody @Valid CommentDTO.Request dto,
                                          BindingResult result, HttpServletRequest request){
        Utils.checkValid4JSON(result);
        dto.setIp(request.getRemoteAddr());
        return modelMapper.map(commentService.modify(id, dto), CommentDTO.Response.class);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeComment(@NonNull @PathVariable Long id){
        commentService.remove(id);
    }

}
