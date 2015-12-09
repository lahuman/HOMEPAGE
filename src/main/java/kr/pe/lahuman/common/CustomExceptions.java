package kr.pe.lahuman.common;

import lombok.Data;

/**
 * Created by lahuman on 15. 12. 9.
 */
public class CustomExceptions {
    @Data
    public static class NotFoundException extends RuntimeException{

        private String type;
        private Long id;

        public NotFoundException(String type, Long id){
            this.type = type;
            this.id = id;
        }
    }
}
