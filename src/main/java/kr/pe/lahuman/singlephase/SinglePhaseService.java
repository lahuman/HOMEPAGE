package kr.pe.lahuman.singlephase;

import kr.pe.lahuman.common.CustomExceptions;
import kr.pe.lahuman.models.SinglePhase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by lahuman on 15. 12. 15.
 */
@Service
@Transactional
public class SinglePhaseService {
    @Autowired
    private SinglePhaseRepository singlePhaseRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final String SERVICE_NAME = "SINGLE_PHASE";

    public SinglePhase add(SinglePhaseDTO singlePhaseDTO){
        SinglePhase singlePhase = modelMapper.map(singlePhaseDTO, SinglePhase.class);
        singlePhase.setRegisterDt(new Date());
        return singlePhaseRepository.save(singlePhase);
    }

    public Page<SinglePhase> list(Pageable pageable){
        return singlePhaseRepository.findAll(pageable);
    }

    public SinglePhase get(Long id){
        SinglePhase singlePhase = singlePhaseRepository.getOne(id);
        if(singlePhase == null){
            throw new CustomExceptions.NotFoundException(SERVICE_NAME, id);
        }
        return singlePhase;
    }

    public SinglePhase modify(Long id, SinglePhaseDTO singlePhaseDTO){
        SinglePhase singlePhase = get(id);
        singlePhase.setContents(singlePhaseDTO.getContents());
        singlePhase.setModifyDt(new Date());
        return singlePhaseRepository.save(singlePhase);
    }

    public void remove(Long id){
        singlePhaseRepository.delete(id);
    }

}
