package WebSite.exceptions;

import java.time.Instant;

public class ErrorResponse {
	private int Status;
	private String error;
	private Instant timestamp;
	private String message;
	private String path;
	
	
	
	public ErrorResponse() {
		super();
	}

	public ErrorResponse(int status, String error, Instant timestamp, String message, String path) {
		super();
		Status = status;
		this.error = error;
		this.timestamp = timestamp;
		this.message = message;
		this.path = path;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
