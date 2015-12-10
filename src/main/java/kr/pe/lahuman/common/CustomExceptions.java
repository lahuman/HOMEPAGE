package kr.pe.lahuman.common;

import lombok.Data;
import org.springframework.validation.BindingResult;

/**
 * Created by lahuman on 15. 12. 9.
 */
public class CustomExceptions {
    @Data
    public static class APINotFoundException extends RuntimeException{
        public APINotFoundException(String serviceCode, Long id){
            super("Could not find ID : "+ id +" ::: SERVICE CODE :  "+serviceCode);
        }
    }

    @Data
    public static class APIBindValidException extends RuntimeException{

        public APIBindValidException(String message) {
            super(message);
        }
    }
}
