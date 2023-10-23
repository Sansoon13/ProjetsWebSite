package WebSite.entities;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;
	@Column(name="user_first_name")
	private String firstName;
	@Column(name="user_last_name")
	private String lastName;
	@Column(name="user_username",unique = true,nullable = false)
	private String username;
	@Column(name="user_email",unique = true,nullable = false)
	@Pattern(regexp="")
	private String email;
	@Column(name="user_password",nullable = false)
	@Pattern(regexp="")
	private String password;
	@Column(name="user_image",columnDefinition = "LONGBLOB")
	private byte[] image;
	@DateTimeFormat
	@Column(name="user_date_entry")
	private LocalDate dateEntry;
	@OneToMany(mappedBy = "author")
	private Set<Evaluation> evaluations;
	
	public User() {
		super();
	}
	
	public User(Long id, String firstName, String lastName, String username,String email,String password,
			byte[] image, LocalDate dateEntry) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.image = image;
		this.dateEntry = dateEntry;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public LocalDate getDateEntry() {
		return dateEntry;
	}
	public void setDateEntry(LocalDate dateEntry) {
		this.dateEntry = dateEntry;
	}

	

	public Set<Evaluation> getEvaluations() {
		return evaluations;
	}



	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
