package com.springboot.enums;

/**
 * @author leo
 * API 統一返回的狀態碼
 * */
public enum ApiReturnStatusCode {
	
	//返回正常
	REQUEST_SUCCESS(200, "Request Success", "請求正常"),
	//用户ID异常
	INVALID_USER(400, "Invalid User ID", "用户ID異常"),
	//信息获取失败
	REQUEST_FAIL(401, "Request Fail", "信息获取失败"),
	//请求错误
	INVALID_REQUEST(403, "Invalid Request", "请求错误");

	private int code;
    private String msg;
    private String zhMsg;

    ApiReturnStatusCode(int code, String msg, String zhMsg) {
        this.code = code;
        this.msg = msg;
        this.zhMsg = zhMsg;
    }

    public int code() {
        return this.code;
    }

    public String msg() {
        return this.msg;
    }
    
    public String zhMsg() {
        return this.zhMsg;
    }
	
}
