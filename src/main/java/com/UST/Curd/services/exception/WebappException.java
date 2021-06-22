package com.UST.Curd.services.exception;

import org.springframework.http.HttpStatus;

public class WebappException extends Exception {

	private static final long serialVersionUID = -4905710129413496307L;
	private final HttpStatus errorCode;
	private final String message;
	private final Object details;
	private final CustomErrorCode customErrorCode;

	public WebappException(Response<String> webAppException) {
		message = webAppException.getResult();
		errorCode = webAppException.getHttpStatus();
		details = webAppException.getWebappException() == null ? null
				: webAppException.getWebappException().getDetails();
		customErrorCode = null;
	}

	public WebappException() {
		this.errorCode = null;
		this.details = null;
		this.message = null;
		customErrorCode = null;

	}

	public WebappException(String message, Object details) {
		this.details = details;
		this.message = message;
		this.errorCode = null;
		customErrorCode = null;

	}

	public WebappException(String message, Object details, HttpStatus code) {
		this.details = details;
		this.message = message;
		this.errorCode = code;
		customErrorCode = null;

	}

	public WebappException(String msg, Throwable cause) {
		super(cause);
		this.message = msg;
		this.errorCode = null;
		this.details = null;
		customErrorCode = null;

	}

	public WebappException(String msg, HttpStatus code, Throwable cause) {
		super(cause);
		this.errorCode = code;
		this.message = msg;
		this.details = null;
		customErrorCode = null;

	}

	public WebappException(HttpStatus errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
		this.details = null;
		customErrorCode = null;

	}

	public WebappException(Exception exception, String message) {
		super(exception);
		this.message = message;
		this.errorCode = null;
		this.details = null;
		customErrorCode = null;

	}

	public WebappException(WebappException exception) {
		super(exception);
		this.message = exception.getMessage();
		this.details = exception.getDetails();
		this.errorCode = exception.getErrorCode();
		customErrorCode = null;

	}

	public WebappException(Exception exception) {
		super(exception);
		this.message = exception.getMessage();
		this.details = null;
		this.errorCode = null;
		customErrorCode = null;

	}

	public WebappException(String message) {
		this.message = message;
		this.details = null;
		this.errorCode = null;
		customErrorCode = null;

	}

	public WebappException(Exception e, String message, HttpStatus code) {
		super(e);
		this.errorCode = code;
		this.message = message;
		this.details = null;
		customErrorCode = null;

	}

	public WebappException(String message, HttpStatus code) {
		this.errorCode = code;
		this.message = message;
		this.details = null;
		customErrorCode = null;

	}

	public WebappException(String message, HttpStatus code, CustomErrorCode customErrorCode) {
		this.errorCode = code;
		this.message = message;
		this.details = null;
		this.customErrorCode = customErrorCode;

	}

	public WebappException(Exception e, HttpStatus httpStatus) {
		super(e);
		this.message = e.getMessage();
		this.errorCode = httpStatus;
		this.details = null;
		customErrorCode = null;

	}

	public Object getDetails() {
		return details;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "WebappException{" + "errorCode=" + errorCode + ", message='" + message + '\'' + ", details=" + details
				+ '}';
	}

	public CustomErrorCode getCustomErrorCode() {
		return customErrorCode;
	}
}
