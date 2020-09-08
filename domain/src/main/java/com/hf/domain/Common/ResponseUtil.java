package com.hf.domain.Common;

import java.io.Serializable;

//高可用 response 返回对象
public class ResponseUtil implements Serializable {
    private String status;
    private String msg;
    private Object result;
    private String jwtToken;

    public ResponseUtil() {

    }
    public ResponseUtil(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    public ResponseUtil(String status, String msg,String jwtToken) {
        this.status = status;
        this.msg = msg;
        this.jwtToken = jwtToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
