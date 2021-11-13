package com.farukdegerli.ItemService.exceptioHandler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class ExceptionResponse {
    public ExceptionResponse(Date date, String message) {
        this.date = date;
        this.message = message;
    }
    private Date date;
    private String message;
}