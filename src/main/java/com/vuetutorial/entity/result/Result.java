package com.vuetutorial.entity.result;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Result<D> {

    private final Integer code;

    private final String message;

    private D data;

    public Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public Result(ResultEnum resultEnum, D data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code.equals(ResultEnum.SUCCESS.getCode());
    }

}
