package WebSite.request;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import WebSite.entities.Adresse;
import WebSite.entities.Role;
import WebSite.entities.User;

public class UserRequest {
	private String username;
	private String password;
	private String lastName;
	private String firstName;
	private String email;
	private Role role=Role.ROle_USER;
	private LocalDate dateEntry;
	private Adresse adresse;
	public UserRequest() {
		
	}
	
	public User toUserEntity() {
		User user=new User();
		BeanUtils.copyProperties(this, user);
		return user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LocalDate getDateEntry() {
		return dateEntry;
	}

	public void setDateEntry(LocalDate dateEntry) {
		this.dateEntry = dateEntry;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
}
