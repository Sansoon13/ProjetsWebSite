package WebSite.request;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import WebSite.entities.Adresse;
import WebSite.entities.Role;
import WebSite.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RegisterRequest {
	
	private String firstName;
	private String lastName;
	@Email(message="email format is not valid")
	private String email;
	@NotNull(message="username is required")
	private String username;
	@NotNull(message="password is required")
	private String password;
	private LocalDate dateEntry=LocalDate.now();
	private Adresse adresse;
	@NotNull
	private Role role;
	
	public User toUserEntity() {
		User user=new User();
		BeanUtils.copyProperties(this, user);
		return user;
	}
	
	public RegisterRequest() {
		super();
	}
	
	public RegisterRequest(String firstName, String lastName,
			@Email(message = "email format is not valid") String email,
			@NotNull(message = "username is required") String username,
			@NotNull(message = "password is required") String password, LocalDate dateEntry, Adresse adresse,
			@NotNull Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.dateEntry = dateEntry;
		this.adresse = adresse;
		this.role = role;
		System.out.println("request !!!!!");
	}



	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
