package WebSite.exceptions;

import WebSite.entities.User;

public class UserException extends RuntimeException{

	public UserException(String message) {
		super(message);
	}
	
	public UserException(Long id) {
		super("User with "+id+" is unknown");
	}
	
	
	
}
