package kr.pe.lahuman.myhistory;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lahuman on 15. 12. 8.
 */
@RestController(value = "/myhistory")
public class MyHisotryController {
    @Autowired
    private MyHistoryService myHistoryService;

    @Autowired
    private ModelMapper modelMapper;


    @RequestMapping
    public List<MyHistoryDTO.Response> getMyHistory(){
        return myHistoryService.list().stream()
                .map(myHistory -> modelMapper.map(myHistory, MyHistoryDTO.Response.class)).collect(Collectors.toList());
    }

}
