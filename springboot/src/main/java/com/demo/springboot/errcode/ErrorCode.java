package com.demo.springboot.errcode;

public enum ErrorCode {
    SUCCESS("0", "成功"),
    UNKNOWN_ERROR("2", "不明错误 "),
    UNKNOWN_EXCEPTION("-1", "未知异常"),
    GET_ERROR_RETURN_CODE("1000", "返回值异常"),
    INTERRUPTED_ERROR("1001","线程异常"),
    TIMEOUT_ERROR("1002","请求超时"),
    ;
    /**
     * 状态码
     */
    private String code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 构造函数
     * @param code    状态码
     * @param message 提示信息
     */
    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取状态码
     * @return 状态码
     */
    public String getCode() {
        return this.code;
    }

    /**
     * 获取提示信息
     * @return 提示信息
     */
    public String getMessage() {
        return this.message;
    }
}
