package kr.pe.lahuman.myhistory;

import kr.pe.lahuman.common.CustomExceptions;
import kr.pe.lahuman.models.MyHistory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by lahuman on 15. 12. 8.
 */
@Service
public class MyHistoryService {

    @Autowired
    private MyHistoryRepository myHistoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final String MY_HISTORY = "MY_HISTORY";

    public Page<MyHistory> list(Pageable pageable){
        return myHistoryRepository.findAll(pageable);
    }

    public MyHistory addMyHistory(MyHistoryDTO.Create createDto) {
        MyHistory myHistory = modelMapper.map(createDto, MyHistory.class);
        myHistory.setRegisterDt(new Date());
        return myHistoryRepository.save(myHistory);
    }

    public MyHistory modifyMyHistory(Long id, MyHistoryDTO.Update updateDto){
        MyHistory myHistory = getMyHistory(id);
        myHistory.setYear(updateDto.getYear());
        myHistory.setStartMonth(updateDto.getStartMonth());
        myHistory.setEndMonth(updateDto.getEndMonth());
        myHistory.setContents(updateDto.getContents());
        myHistory.setModifyDt(new Date());
        return myHistoryRepository.save(myHistory);
    }

    public MyHistory getMyHistory(Long id){
        MyHistory myHistory = myHistoryRepository.findOne(id);
        if(myHistory == null){
            throw new CustomExceptions.APINotFoundException(MY_HISTORY, id);
        }
        return myHistory;
    }

    public void removeMyHistory(Long id){
        myHistoryRepository.delete(getMyHistory(id));
    }




}
