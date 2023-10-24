package WebSite.response;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import WebSite.entities.User;

public class UserResponse {
	private Long id;
	private String username;
	private String lastName;
	private String firstName;
	private LocalDate dateEntry;
	private byte[] image;
	
	public UserResponse() {
		
	}
	
	public UserResponse(User user) {
		BeanUtils.copyProperties(user, this);
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getDateEntry() {
		return dateEntry;
	}

	public void setDateEntry(LocalDate dateEntry) {
		this.dateEntry = dateEntry;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
}
