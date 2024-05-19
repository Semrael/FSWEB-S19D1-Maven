package com.workintech.s18d2.exceptions;

import lombok.*;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private int status;
    private LocalDateTime dateTime;



}
