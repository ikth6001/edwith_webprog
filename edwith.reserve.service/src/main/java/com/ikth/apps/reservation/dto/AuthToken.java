package com.ikth.apps.reservation.dto;

public class AuthToken 
{
	private String token;
	private boolean success;
	private String failMsg;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getFailMsg() {
		return failMsg;
	}
	public void setFailMsg(String failMsg) {
		this.failMsg = failMsg;
	}
}
