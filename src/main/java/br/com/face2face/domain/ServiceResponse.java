package br.com.face2face.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ServiceResponse {
    private HttpStatus httpStatus;
    private String message;
    private Object obj;
}
