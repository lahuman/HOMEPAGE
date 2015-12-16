package kr.pe.lahuman.myhistory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.pe.lahuman.Application;
import kr.pe.lahuman.comment.CommentDTO;
import kr.pe.lahuman.comment.CommentService;
import kr.pe.lahuman.models.Comment;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
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
 * Created by lahuman on 15. 12. 16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class CommentTest {
    @Autowired
    WebApplicationContext wac;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    CommentService commentService;

    MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .build();
    }

    @Test
    public void addComment() throws Exception {
        CommentDTO.Request master = new CommentDTO.Request();
        master.setComment("sdfasdf");
        master.setName("sdfasdf");
        Comment comment = commentService.add(master);
        CommentDTO.Request request1 = new CommentDTO.Request();
        CommentDTO.Request request2 = new CommentDTO.Request();
        request1.setComment("가나다라 마바사 아자차마 파타하");
        request1.setName("개나리");
        request2.setComment("sdfasdf");
        request2.setName("sdfasdf");
        request2.setMainId(comment.getId());

//        master.getComment().

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/comment/MYHI")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request2)));


        result.andDo(MockMvcResultHandlers.print());
        result.andExpect(MockMvcResultMatchers.status().isOk());
        //{"content":[{"author":"lahuman","title":"title - 1","body":"I made Board CRUD Program.\nThat time I didn't understand JPA.\nSo I am refactoring it.\n\nI follow \"https://github.com/keesun/amugona\".\n","createDate":1442817128582},{"author":"lahuman","title":"lahuman-2","body":"jamesgoslingNo worries.\njamesgoslingIs it cold now in korea?","createDate":1442817128771,"updateDate":1442817128838},{"author":"lahuman","title":"title - 1","body":"I made Board CRUD Program.\nThat time I didn't understand JPA.\nSo I am refactoring it.\n\nI follow \"https://github.com/keesun/amugona\".\n","createDate":1442817128973}],"last":true,"totalElements":3,"totalPages":1,"size":20,"number":0,"numberOfElements":3,"first":true}
//        result.andExpect(MockMvcResultMatchers.jsonPath("$.totalElements", CoreMatchers.is(5)));

        commentService.get(1L).getSubComment().stream().forEach(c -> System.out.println(c.getId()));
    }
}
