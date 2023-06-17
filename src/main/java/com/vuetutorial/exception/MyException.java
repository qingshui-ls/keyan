package com.vuetutorial.exception;

public class MyException extends Exception {
    private Integer code;
    private String message;

    public MyException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

