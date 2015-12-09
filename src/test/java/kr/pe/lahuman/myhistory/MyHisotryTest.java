package kr.pe.lahuman.myhistory;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.pe.lahuman.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by lahuman on 15. 12. 8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MyHisotryTest {
    @Autowired
    WebApplicationContext wac;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MyHistoryService myHistoryService;

    MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .build();
    }

    @Test
    public void getMyHistoryList() throws Exception {
        MyHistoryDTO.Create createDto = new MyHistoryDTO.Create();
        //set Data
        createDto.setYear("2015");
        createDto.setStartMonth("01");
        createDto.setEndMonth("12");
        createDto.setContents("기상청 유지관리");

        myHistoryService.addMyHistory(createDto);
        myHistoryService.addMyHistory(createDto);
        myHistoryService.addMyHistory(createDto);
        myHistoryService.addMyHistory(createDto);
        myHistoryService.addMyHistory(createDto);



        Pageable pageable = new PageRequest(1, 5);
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/myhisotry")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pageable)));

        result.andDo(MockMvcResultHandlers.print());
        result.andExpect(MockMvcResultMatchers.status().isOk());
        //{"content":[{"author":"lahuman","title":"title - 1","body":"I made Board CRUD Program.\nThat time I didn't understand JPA.\nSo I am refactoring it.\n\nI follow \"https://github.com/keesun/amugona\".\n","createDate":1442817128582},{"author":"lahuman","title":"lahuman-2","body":"jamesgoslingNo worries.\njamesgoslingIs it cold now in korea?","createDate":1442817128771,"updateDate":1442817128838},{"author":"lahuman","title":"title - 1","body":"I made Board CRUD Program.\nThat time I didn't understand JPA.\nSo I am refactoring it.\n\nI follow \"https://github.com/keesun/amugona\".\n","createDate":1442817128973}],"last":true,"totalElements":3,"totalPages":1,"size":20,"number":0,"numberOfElements":3,"first":true}
        //result.andExpect(MockMvcResultMatchers.jsonPath("$.totalElements", CoreMatchers.is(3)));


    }
}
