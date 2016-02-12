package kr.pe.lahuman.notice;

import kr.pe.lahuman.common.CustomExceptions;
import kr.pe.lahuman.models.Notice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by lahuman on 2016. 2. 12..
 */
@Service
public class NoticeService {

    @Autowired
    private NoticeRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    private final String SERVICE_NAME = "Notice";


    public Page<Notice> list(Pageable pageble){
        return repository.findAll(pageble);
    }

    public Notice addNotice(NoticeDTO.Request dto){
        Notice notice = modelMapper.map(dto, Notice.class);
        notice.setRegisterDt(new Date());
        return repository.save(notice);
    }

    public Notice modifyNotice(Long id, NoticeDTO.Request dto){
        Notice notice = getNotice(id);
        notice.setContents(dto.getContents());
        notice.setTitle(dto.getTitle());
        notice.setModifyDt(new Date());

        return repository.save(notice);
    }

    public Notice getNotice(Long id) {
        Notice notice = repository.getOne(id);
        if(notice == null){
            throw new CustomExceptions.NotFoundException(SERVICE_NAME, id);
        }
        return notice;
    }


    public void removeNotice(Long id){
        repository.delete(getNotice(id));
    }
}
