package kr.pe.lahuman.myhistory;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.pe.lahuman.Application;
import kr.pe.lahuman.project.ProjectDTO;
import kr.pe.lahuman.project.ProjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Set;

/**
 * Created by lahuman on 15. 12. 10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ProjectTest {
    @Autowired
    WebApplicationContext wac;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ProjectService service;

    MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .build();
    }


    @Test
    public void getMyHistoryList() throws Exception {
        ProjectDTO.Request dto = new ProjectDTO.Request();

        dto.setName("기상청 유지관리 업무");
        dto.setContents("전자민원 유지관리 및 개선");
        dto.setProjectUrl("http://minwon.kma.go.kr");
        dto.setImageFile("/data/images/minwon.gif");




    }

}
