package com.doufu.words.Model.vo;


import java.io.Serializable;

public class Result<T> implements Serializable {

	/**
	 * 
	 * 
	 * 参照支付宝https://opendocs.alipay.com/open/common/105806
	 * 
	 * 10000 接口调用成功，调用结果请参考具体的 API 文档所对应的业务返回参数。
	 * 
	 * 20000 服务暂不可用（网关自身的未知错误）请稍后重试
	 * 
	 * 20001网络出问题了,为CODE=20001
	 * 
	 * 20002未登录需要登录,为CODE=20002
	 * 
	 */

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public static final String DEFAULT_SUCCESSS_CODE = "10000";

	public static final String DEFAULT_SUCCESSS_MESSAGE = "成功";

	public static final String DEFAULT_FAIL_CODE = "20000";

	public static final String DEFAULT_FAIL_MESSAGE = "失败";

	public static final String DEFAULT_FAIL_MESSAGE_TWO = "失败,服务暂不可用请稍后重试";

	private String code;

	private String message;

	private T data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Result() {
		super();
	}

	public Result(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public Result(String code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	/**
	 * 响应成功,操作成功
	 * 
	 * @return
	 */
//	public Boolean respSuccess() {
//		if (null == this.getCode()) {
//			return false;
//		}
//		if (StringUtils.isBlank(this.getCode())) {
//			return false;
//		}
//		if (DEFAULT_SUCCESSS_CODE.equals(this.getCode())) {
//			return true;
//		}
//		return false;
//
//	}

	public static <T> Result<T> createSuccessDefault() {
		Result<T> result = new Result<T>(DEFAULT_SUCCESSS_CODE, DEFAULT_SUCCESSS_MESSAGE);
		return result;
	}

	public static <T> Result<T> createSuccessDefault(T data) {
		Result<T> result = new Result<T>(DEFAULT_SUCCESSS_CODE, DEFAULT_SUCCESSS_MESSAGE, data);
		return result;
	}

	public static <T> Result<T> createSuccess() {
		Result<T> result = new Result<T>(DEFAULT_SUCCESSS_CODE, DEFAULT_SUCCESSS_MESSAGE);
		return result;
	}

	public static <T> Result<T> createSuccess(String message) {
		Result<T> result = new Result<T>(DEFAULT_SUCCESSS_CODE, message);
		return result;
	}

	public static <T> Result<T> createSuccess(T data) {
		Result<T> result = new Result<T>(DEFAULT_SUCCESSS_CODE, DEFAULT_SUCCESSS_MESSAGE, data);
		return result;
	}

	public static <T> Result<T> createSuccess(String message, T data) {
		Result<T> result = new Result<T>(DEFAULT_SUCCESSS_CODE, message, data);
		return result;
	}

	//

	public static <T> Result<T> createFail() {
		Result<T> result = new Result<T>(DEFAULT_FAIL_CODE, DEFAULT_FAIL_MESSAGE);
		return result;
	}

	public static <T> Result<T> createFail(String message) {
		Result<T> result = new Result<T>(DEFAULT_FAIL_CODE, message);
		return result;
	}

	public static <T> Result<T> createFail(T data) {
		Result<T> result = new Result<T>(DEFAULT_FAIL_CODE, DEFAULT_FAIL_MESSAGE, data);
		return result;
	}

	public static <T> Result<T> createFail(String message, T data) {
		Result<T> result = new Result<T>(DEFAULT_FAIL_CODE, message, data);
		return result;
	}

}
