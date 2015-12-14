package kr.pe.lahuman.common;

import lombok.Data;

/**
 * Created by lahuman on 15. 12. 9.
 */
public class CustomExceptions {

    private CustomExceptions(){};

    @Data
    public static class NotFoundException extends RuntimeException{
        public NotFoundException(String serviceCode, Long id){
            super("Could not find ID : "+ id +" ::: SERVICE CODE :  "+serviceCode);
        }
    }

    @Data
    public static class JSONBindValidException extends RuntimeException{
        public JSONBindValidException(String message) {
            super(message);
        }
    }
}
