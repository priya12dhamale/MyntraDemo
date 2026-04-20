package com.exceptions;

public class InvalidBrowserNameExc extends RuntimeException {

	private String BrowserName;

	public void invalidBrowserNameException(String BrowserName) {

		this.BrowserName = BrowserName;
	}

	@Override
	public String getMessage() {
		return BrowserName;

	}

}
