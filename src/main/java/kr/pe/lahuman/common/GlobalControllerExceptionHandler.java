package kr.pe.lahuman.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lahuman on 15. 12. 7.
 */
@ControllerAdvice(basePackages = "kr.pe.lahuman")
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler({CustomExceptions.APINotFoundException.class, CustomExceptions.APIBindValidException.class})
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(ex);
        return new ResponseEntity<>(new CustomErrorResponse(status.value(), status.getReasonPhrase(), ex.getMessage(), request.getServletPath()), status);
    }

    private HttpStatus getStatus(Throwable ex) {
        if(ex instanceof CustomExceptions.APINotFoundException){
            return HttpStatus.NOT_FOUND;
        }else if( ex instanceof CustomExceptions.APIBindValidException){
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
