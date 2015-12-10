package kr.pe.lahuman.common;

import lombok.Data;
import org.springframework.util.MultiValueMap;

import java.util.Date;

/**
 * Created by lahuman on 15. 12. 9.
 */
@Data
public class CustomErrorResponse {

    private int status;
    private String error;
    private String message;
    private String path;
    private Date timestamp;

    public CustomErrorResponse(int status, String error, String message, String path) {
        this.status = status;
        this.message = message;
        this.error = error;
        this.path = path;
        timestamp = new Date();
    }
}
