package com.UST.Curd.services.exception;

import com.UST.Curd.services.constant.OperationStatus;

public class Result<T> {

	private T res;
	private OperationStatus status;
	private Exception exception;

	public Result() {
	}

	public Result(T res, OperationStatus status) {
		this.res = res;
		this.status = status;
	}

	public Result(Exception exception) {
		this.exception = exception;
	}

	public Result(Exception exception, OperationStatus status) {
		this.exception = exception;
		this.status = status;
	}

	public T getResult() {
		return res;
	}

	public void setResult(T res) {
		this.res = res;
	}

	public OperationStatus getStatus() {
		return status;
	}

	public void setStatus(OperationStatus status) {
		this.status = status;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

}
