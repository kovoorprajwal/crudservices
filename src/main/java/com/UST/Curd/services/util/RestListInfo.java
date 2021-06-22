package com.UST.Curd.services.util;
import java.util.List;

/**
 * @author kovoor.prajwal
 * @Date : January, 2021
 *
 */
public class RestListInfo<T> {

	private int operationCode;
	private String message;
	private List<T> data;

	public RestListInfo() {
	}

	public int getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(int operationCode) {
		this.operationCode = operationCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public RestListInfo(int operationCode, String message, List<T> data) {
		super();
		this.operationCode = operationCode;
		this.message = message;
		this.data = data;
	}

}