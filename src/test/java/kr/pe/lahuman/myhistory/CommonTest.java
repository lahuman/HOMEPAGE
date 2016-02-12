package kr.pe.lahuman.myhistory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.pe.lahuman.notice.NoticeDTO;
import org.junit.Test;

/**
 * Created by lahuman on 2016. 2. 13..
 */
public class CommonTest {

    @Test
    public void getJsonData(){

        NoticeDTO.Request request = new NoticeDTO.Request();
        request.setContents(" 첫번째테스트입니다.");
        request.setTitle("제목");

        try {
            System.out.println(new ObjectMapper().writeValueAsString(request));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
