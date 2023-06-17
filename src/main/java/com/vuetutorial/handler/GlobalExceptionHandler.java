package com.vuetutorial.handler;

import com.vuetutorial.entity.result.Result;
import com.vuetutorial.entity.result.ResultEnum;
import com.vuetutorial.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


// 全局异常处理器

@ControllerAdvice
public class GlobalExceptionHandler {

 /*@ExceptionHandler(MyException.class)
     @ResponseBody
     public ResponseEntity<ErrorResponse> handleMyException(MyException e) {
         ErrorResponse errorResponse = new ErrorResponse(e.getCode(), e.getMessage());
         return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
     }*/

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Object> handleException(Exception e) {
        return new Result<>(ResultEnum.SERVER_ERROR, null);
    }
}

