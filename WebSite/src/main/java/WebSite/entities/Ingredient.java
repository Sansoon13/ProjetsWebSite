package WebSite.entities;

import java.util.Objects;
import java.util.Set;

import org.aspectj.weaver.tools.Trace;

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
	@Column(name="ingredient_name",unique = true)
	private String name;
	@OneToMany(mappedBy = "ingredient")
	private Set<IngredProd> produits;
	
	public Ingredient() { 
		super();
	}

	public Ingredient(Long id, String name, Set<IngredProd> produits) {
		super();
		this.id = id;
		this.name = name;
		this.produits = produits;
	}
	

	public Ingredient(String name, Set<IngredProd> produits) {
		super();
		this.name = name;
		this.produits = produits;
	}

	public Ingredient(String name) {
		super();
		this.name = name;
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

	

	public Set<IngredProd> getProduits() {
		return produits;
	}

	public void setProduits(Set<IngredProd> produits) {
		this.produits = produits;
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
