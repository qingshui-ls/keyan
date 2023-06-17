package com.vuetutorial.entity.result;

public enum ResultEnum {

    SUCCESS(200, "成功"),
    PASSWORD_ERROR(406, "密码或账号错误"),
    NO_PERMISSION(403, "权限不足"),
    PARAMETER_ILLEGAL(407, "请求参数不合法"),

    NOT_FOUND(404, "资源不存在"),

    SERVER_ERROR(500, "服务器错误");

    private final Integer code;

    private final String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ResultEnum{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
