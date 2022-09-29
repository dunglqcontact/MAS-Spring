package com.dunglq.masdemo.request;

import com.dunglq.masdemo.annotation.CustomNotBlank;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
public class CreateAccountDTO implements Serializable {
    @CustomNotBlank(statusCode = 1001, message = "userName must not blank", httpStatus = HttpStatus.BAD_REQUEST)
    private String userName;
    @CustomNotBlank(statusCode = 1002, message = "password must not blank", httpStatus = HttpStatus.BAD_REQUEST)
    private String password;
}