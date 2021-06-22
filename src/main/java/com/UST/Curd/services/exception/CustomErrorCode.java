package com.UST.Curd.services.exception;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CustomErrorCode implements Serializable {

	private String code;
	private String message;
	private Object data;

	@SuppressWarnings("unused")
	private CustomErrorCode() {
	}

	public CustomErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public CustomErrorCode(String code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		CustomErrorCode that = (CustomErrorCode) o;

		return code != null ? code.equals(that.code) : that.code == null;
	}

	@Override
	public int hashCode() {
		return code != null ? code.hashCode() : 0;
	}
}
