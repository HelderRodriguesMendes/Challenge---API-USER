package com.testePratico.API_User.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {
    private Integer status;
    private Long timesTamp;
    private String message;
}
