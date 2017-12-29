package com.example.domain;

public class Response {

	private int statusCode;
	private String description;

	public Response(int statusCode, String description) {
		this.statusCode = statusCode;
		this.description = description;
	}

	public int getStatus() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
