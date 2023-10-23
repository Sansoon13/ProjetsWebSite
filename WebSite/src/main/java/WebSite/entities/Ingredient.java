package WebSite.entities;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ingredient")
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="ingredient_name")
	private String name;
	@OneToMany(mappedBy = "ingredient")
	private Set<IngredProd> ingredprod;
	
	public Ingredient() {
		super();
	}

	public Ingredient(Long id, String name, Set<IngredProd> ingredprod) {
		super();
		this.id = id;
		this.name = name;
		this.ingredprod = ingredprod;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<IngredProd> getIngredProd() {
		return ingredprod;
	}

	public void setIngredProd(Set<IngredProd> ingredprod) {
		this.ingredprod = ingredprod;
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
		Ingredient other = (Ingredient) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
