package kr.pe.lahuman.common;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.stream.Collectors;

/**
 * Created by lahuman on 15. 12. 10.
 */
public class Utils {
    private Utils(){}

    public static void checkValid4JSON(BindingResult result) {
        if(result.hasErrors()){

            String errorMsg = result.getAllErrors().stream()
                .filter(f -> f instanceof FieldError)
                .map(fieldError -> ((FieldError)fieldError).getField() + ":[" + fieldError.getCode()+"] "+fieldError.getDefaultMessage())
                .collect(Collectors.joining(", "));
            throw new CustomExceptions.JSONBindValidException(errorMsg);

//            StringBuilder errorMsg = new StringBuilder();
//            for (Object object : result.getAllErrors()) {
//                if(object instanceof FieldError) {
//                    FieldError fieldError = (FieldError) object;
//
//                    errorMsg.append(fieldError.getField()+":"+fieldError.getCode());
//                }
//            }
//            throw new CustomExceptions.JSONBindValidException(errorMsg.toString());
        }
    }

}
