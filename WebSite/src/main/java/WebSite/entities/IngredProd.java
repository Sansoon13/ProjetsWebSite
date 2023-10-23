package WebSite.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ingredprod")
public class IngredProd {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="ingredprod_product_id",foreignKey = @ForeignKey(name="ingredprod_product_id_fk"))
	private Product product;
	@ManyToOne
	@JoinColumn(name="ingredprod_ingredient_id",foreignKey = @ForeignKey(name="ingredprod_ingredient_id_fk"))
	private Ingredient ingredient;
	
	
	
	public IngredProd() {
		super();
	}


	public IngredProd(Long id, Product product, Ingredient ingredient) {
		super();
		this.id = id;
		this.product = product;
		this.ingredient = ingredient;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Ingredient getIngredient() {
		return ingredient;
	}


	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
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
		IngredProd other = (IngredProd) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
