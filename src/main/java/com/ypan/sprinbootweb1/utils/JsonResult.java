package com.ypan.sprinbootweb1.utils;

import com.ypan.sprinbootweb1.config.Constants;

/**
 * 返回结果通用类
 */
public class JsonResult {
    /**
     * 返回状态码
     */
    private Integer status;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据集
     */
    private Object data;

    private JsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static JsonResult ok() {
        return new JsonResult(Constants.INTEGER_NUM.INTEGER_OK.getVal(), Constants.STRING_MSG.STRING_OK.getVal(), null);
    }

    public static JsonResult ok(Object data) {
        return new JsonResult(Constants.INTEGER_NUM.INTEGER_OK.getVal(), Constants.STRING_MSG.STRING_OK.getVal(), data);
    }

    public static JsonResult ok(String msg, Object data) {
        return new JsonResult(Constants.INTEGER_NUM.INTEGER_OK.getVal(), msg, data);
    }

    public static JsonResult error(Object data) {
        return new JsonResult(Constants.INTEGER_NUM.INTEGER_ERROR.getVal(), Constants.STRING_MSG.STRING_ERROR.getVal(), data);
    }

    public static JsonResult error(String msg, Object data) {
        return new JsonResult(Constants.INTEGER_NUM.INTEGER_ERROR.getVal(), msg, data);
    }

    public static JsonResult build(Integer status, String msg, Object data) {
        return new JsonResult(status, msg, data);
    }
}
