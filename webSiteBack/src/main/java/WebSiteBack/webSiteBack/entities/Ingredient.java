package WebSiteBack.webSiteBack.entities;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ingredient_id")
	private Long id;
	@Column(name="ingredient_title")
	private String title;
	@OneToMany(mappedBy = "ingredientId")
	private Set<IngredProduct> ingredProduct;
	
	public Ingredient() {
		super();
	}
	
	public Ingredient(Long id, String title, Set<IngredProduct> ingredProduct) {
		super();
		this.id = id;
		this.title = title;
		this.ingredProduct = ingredProduct;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Set<IngredProduct> getIngredProduct() {
		return ingredProduct;
	}
	public void setIngredProduct(Set<IngredProduct> ingredProduct) {
		this.ingredProduct = ingredProduct;
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
