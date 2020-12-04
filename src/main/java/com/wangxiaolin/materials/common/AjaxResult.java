package com.wangxiaolin.materials.common;

/**
 * @author wangxiaolin
 * @date 2019/12/27 - 20:37
 */
public class AjaxResult<T> {
    private static final int CODE_SUCCESS = 0;

    private static final int CODE_FAIL = -1;

    private static final String MSG_SUCCESS="execute success!";
    private static final String MSG_FAIL=" execute failed!";

    private int code=0;
    private String msg="";
    public long count;
    private Object data;

    public AjaxResult(){

    }

    public AjaxResult(int code){
        this.code = code;
    }

    public AjaxResult(int code, Object data){
        this.code = code;
        this.data = data;
    }

    public AjaxResult(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public AjaxResult(int code, String msg,Object data) {
        this.code = code;
        this.msg = msg;
        this.data=data;
    }
    public AjaxResult(int code, String msg,long count,Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data=data;
    }
    public static AjaxResult success(){
        return new AjaxResult(CODE_SUCCESS,MSG_SUCCESS);
    }

    public static AjaxResult success(int successCode,String successlMsg){ return new AjaxResult(successCode,successlMsg); }

    public static AjaxResult success(int successCode,String successlMsg,Object data){ return new AjaxResult(successCode,successlMsg,data); }

    public static AjaxResult success(Object data){
        return new AjaxResult(CODE_SUCCESS,MSG_SUCCESS,data);
    }

    public static AjaxResult success(long count,Object data){ return new AjaxResult(CODE_SUCCESS,MSG_SUCCESS,count,data); }

    public static AjaxResult fail(){
        return new AjaxResult(CODE_FAIL, MSG_FAIL);
    }

    public static AjaxResult fail(int failCode,String failMsg){
        return new AjaxResult(failCode, failMsg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
