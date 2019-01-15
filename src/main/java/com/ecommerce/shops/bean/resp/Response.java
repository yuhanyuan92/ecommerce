package com.ecommerce.shops.bean.resp;

public class Response<T> {
    public Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.setStatus(SuccessCode.SUCCESS.getCode());
        result.setMsg(SuccessCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public Result<T> fail() {
        Result<T> result = new Result<>();
        result.setStatus(ErrorCode.Error.getCode());
        result.setMsg(ErrorCode.Error.getMessage());
        return result;
    }

    public Result<T> fail(String message) {
        Result<T> result = new Result<>();
        result.setStatus(0000);
        result.setMsg(message);
        return result;
    }

    public Result<T> fail(Integer code, String text) {
        Result<T> result = new Result<>();
        result.setStatus(code);
        result.setMsg(text);
        return result;
    }
}