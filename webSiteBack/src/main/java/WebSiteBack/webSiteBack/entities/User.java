package WebSiteBack.webSiteBack.entities;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="user_id")
	private Long id;
	@Column(name="user_first_name")
	private String firstName;
	@Column(name="user_last_name")
	private String lastName;
	@Column(name="user_userame",unique = true,nullable = false)
	private String username;
	@Column(name="user_email",unique = true,nullable = false)
	@Email
	@Pattern(regexp ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message="email invalide")
	private String email;
	@NonNull
	@Column(name="user_password")
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message="mdp invalide")
	private String password;
	@Column(name="user_image",columnDefinition = "TEXT")
	private String image;
	@Column(name="user_date_entry")
	private LocalDate dateEntry;
	@Column(name="user_role")
	@Enumerated
	private Role role;
	@Column(name="user_evaluations")
	private Set<Evaluation> evaluations;
	
	public User() {
		super();
	}
	
	public User(Long id, String firstName, String lastName, String username, String email, String password,
			String image, LocalDate dateEntry) {
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

	public User(Long id, String firstName, String lastName, String username, String email, String password,
			String image, LocalDate dateEntry, Role role, Set<Evaluation> evaluations) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.image = image;
		this.dateEntry = dateEntry;
		this.role = role;
		this.evaluations = evaluations;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDate getDateEntry() {
		return dateEntry;
	}

	public void setDateEntry(LocalDate dateEntry) {
		this.dateEntry = dateEntry;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
