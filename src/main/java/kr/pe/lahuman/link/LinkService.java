package kr.pe.lahuman.link;

import kr.pe.lahuman.common.CustomExceptions;
import kr.pe.lahuman.models.Link;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by lahuman on 2015. 12. 26..
 */
@Service
@Transactional
public class LinkService {
    @Autowired
    LinkRepository linkRepository;

    @Autowired
    ModelMapper modelMapper;

    private final String SERVICE_NAME = "LINK";

    public List<Link> listByCode(Link.Code code){
        return linkRepository.findByCode(code);
    }

    public Page<Link> list(Pageable pageable){
        return linkRepository.findAll(pageable);
    }

    public Link get(Long id){
        Link link = linkRepository.findOne(id);
        if(link ==null){
            throw new CustomExceptions.NotFoundException(SERVICE_NAME, id);
        }
        return link;
    }

    public Link add(LinkDTO.Request dto){
        Link link = modelMapper.map(dto, Link.class);
        link.setRegisterDt(new Date());

        return linkRepository.save(link);
    }

    public Link modify(Long id, LinkDTO.Request dto){
        Link link = get(id);
        link.setCode(dto.getCode());
        link.setLink(dto.getLink());
        link.setName(dto.getName());
        link.setModifyDt(new Date());
        return linkRepository.save(link);
    }

    public void remove(Long id){
        linkRepository.delete(id);
    }
}
