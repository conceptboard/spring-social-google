package org.springframework.social.google.api.drive;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

public final class DownloadMetadata {

	public final HttpHeaders headers;
	public final HttpStatus httpStatus;
	public final String statusText;
	public final int bytes;

	public DownloadMetadata(HttpStatus httpStatus, String statusText, HttpHeaders headers, int bytes) {
		this.httpStatus = httpStatus;
		this.statusText = statusText;
		this.headers = headers == null ? null : HttpHeaders.readOnlyHttpHeaders(headers);
		this.bytes = bytes;
	}

	public HttpHeaders getHeaders() {
		return headers;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getStatusText() {
		return statusText;
	}

	public int getBytes() {
		return bytes;
	}
}
