package kr.pe.lahuman.comment;

import kr.pe.lahuman.common.CustomExceptions;
import kr.pe.lahuman.models.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by lahuman on 15. 12. 16.
 */
@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final String SERVICE_NAME = "COMMENT";

    public Comment get(Long id){
        Comment comment = commentRepository.findOne(id);
        if(comment == null){
            throw new CustomExceptions.NotFoundException(SERVICE_NAME, id);
        }
        return comment;
    }

    public Page<Comment> list(Pageable pageable){
        return commentRepository.findAll(pageable);
    }

    public List<Comment> listByCode(Comment.Code code){
        return commentRepository.findByCode(code);
    }

    public List<Comment> listByCodeAndCodeId(Comment.Code code, Long codeId){
        return commentRepository.findByCodeAndCodeId(code, codeId);
    }

    public Comment add(CommentDTO.Request dto){
        Comment comment = modelMapper.map(dto, Comment.class);
        if(dto.getMainId() != null){
            comment.setMain(get(dto.getMainId()));
        }
        comment.setRegisterDt(new Date());
        return commentRepository.save(comment);
    }

    public Comment modify(Long id, CommentDTO.Request dto){
        Comment comment = get(id);
        comment.setName(dto.getName());
        comment.setCode(dto.getCode());
        if(dto.getMainId() != null){
            comment.setMain(get(dto.getMainId()));
        }
        comment.setCodeId(dto.getCodeId());
        comment.setIp(dto.getIp());
        comment.setModifyDt(new Date());
        return commentRepository.save(comment);
    }

    public void remove(Long id){
        commentRepository.delete(id);
    }

}
