package com.cbolije.nexsysbackend.model.dto;

public class RestResponse<T> {

	private T data;
	private boolean hasErrors;
	private String message;
	
	public RestResponse() {
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public boolean isHasErrors() {
		return hasErrors;
	}
	public void setHasErrors(boolean hasErrors) {
		this.hasErrors = hasErrors;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public RestResponse<T> returnError(String message) {
		RestResponse<T> response = new RestResponse<T>();
		response.setHasErrors(true);
		response.setMessage(message);
		return response;
	}
	
	public RestResponse<T> returnSuccess( String message, T data) {
		RestResponse<T> response = new RestResponse<T>();
		response.setMessage(message);
		response.setData(data);
		return response;
	}
}
