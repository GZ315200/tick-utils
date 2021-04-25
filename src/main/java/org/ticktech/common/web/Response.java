package org.ticktech.common.web;


import org.ticktech.common.Const.*;

/**
 * Project: wasta
 * Package: org.ticktech.wasta.common.web
 * <p>
 * Date: 2021/4/21
 * Time: 下午5:07
 * Desc:
 * <p>
 * Created with Zean
 */
public class Response<T> {

    private final String code;

    private final String msg;

    private T data;

    public Response(final String code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(final String code, final String msg, final T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }


    public static <T> Response<T> ok(String code, String msg, T data) {
        return new Response<T>(code, msg, data);
    }

    public static <T> Response<T> ok(String msg, T data) {
        return new Response<T>(ResCode.OK, msg, data);
    }

    public static <T> Response<T> ok(String msg) {
        return new Response<T>(ResCode.OK, msg, null);
    }


    public static <T> Response<T> error(String code, String msg, T data) {
        return new Response<T>(ResCode.ERROR, msg, data);
    }

    public static <T> Response<T> error(String msg, T data) {
        return new Response<T>(ResCode.ERROR, msg, data);
    }

    public static <T> Response<T> error(String msg) {
        return new Response<T>(ResCode.ERROR, msg, null);
    }

}
