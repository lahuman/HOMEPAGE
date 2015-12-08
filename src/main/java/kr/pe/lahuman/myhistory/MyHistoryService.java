package kr.pe.lahuman.myhistory;

import kr.pe.lahuman.models.MyHistory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<MyHistory> list(){
        return myHistoryRepository.findAll();
    }

    public MyHistory addMyHistory(MyHistoryDTO.Create createDto) {
        MyHistory myHistory = modelMapper.map(createDto, MyHistory.class);
        myHistory.setRegist_dt(new Date());
        return myHistoryRepository.save(myHistory);
    }
}
