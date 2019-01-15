package com.ecommerce.shops.bean.resp;

import java.io.Serializable;

/**
 * 返回结果实体
 */
public class Result<T> implements Serializable{

    private static final long serialVersionUID = -703039383929562L;

    private Integer status;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
