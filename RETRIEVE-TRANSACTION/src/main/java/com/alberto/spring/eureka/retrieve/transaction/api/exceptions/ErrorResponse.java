package com.alberto.spring.eureka.retrieve.transaction.api.exceptions;

public class ErrorResponse {
	private String type;
	private int code;
	private StackTraceElement location;
	private String moreInfo;
	
	public ErrorResponse() {}
	
	public ErrorResponse(String type, int code, StackTraceElement location, String moreInfo) {
		this.type = type;
		this.code = code;
		this.location = location;
		this.moreInfo = moreInfo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public StackTraceElement getLocation() {
		return location;
	}

	public void setLocation(StackTraceElement location) {
		this.location = location;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	
	@Override
	public String toString(){ 
		return "\n { \n "
				+ "\t type: "+getType()+"\n"
				+ "\t code: "+getCode()+"\n"
				+ "\t location: "+getLocation().toString()+"\n"
				+ "\t moreInfo: "+getMoreInfo()+"\n"
				+ " } \n";
	 } 
}
