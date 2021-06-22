package com.UST.Curd.services.exception;

import org.springframework.http.HttpStatus;

import com.UST.Curd.services.constant.OperationStatus;

import java.io.Serializable;

public class Response<T> implements Serializable {

	private T result;
	private OperationStatus status;
	private WebappException webappException;
	private String exception;
	private HttpStatus httpStatus;
	private Integer httpStatusCode;
	private CustomErrorCode customError;

	public Response() {
	}

	public Response(T result) {
		this.result = result;
	}

	public Response(T result, OperationStatus status) {
		this.result = result;
		this.status = status;
	}

	public Response(T result, OperationStatus status, HttpStatus httpStatus) {
		this.result = result;
		this.status = status;
		this.httpStatus = httpStatus;
	}

	public Response(WebappException wException) {
		this.webappException = wException;
	}

	public Response(WebappException wException, OperationStatus status) {
		this.webappException = wException;
		this.status = status;
	}

	public Response(Result result) {
		this.result = (T) result.getResult();
		this.status = result.getStatus();
		this.webappException = result.getException() != null ? new WebappException(result.getException()) : null;
		this.httpStatus = HttpStatus.OK;
		this.httpStatusCode = 200;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public OperationStatus getStatus() {
		return status;
	}

	public void setStatus(OperationStatus status) {
		this.status = status;
	}

	public WebappException getWebappException() {
		return webappException;
	}

	public void setWebappException(WebappException webappException) {
		this.webappException = webappException;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Integer getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(Integer httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public CustomErrorCode getCustomError() {
		return customError;
	}

	public void setCustomError(CustomErrorCode customError) {
		this.customError = customError;
	}
}
