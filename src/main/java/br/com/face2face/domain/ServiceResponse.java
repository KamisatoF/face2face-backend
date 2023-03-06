package br.com.face2face.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ServiceResponse {
    private HttpStatus httpStatus;
    private String errorMessage;
    private Object obj;
}
