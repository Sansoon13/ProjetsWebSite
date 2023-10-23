package WebSiteBack.webSiteBack.entities;

import java.util.Objects;

import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ingred_product")
public class IngredProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ingred_product_id")
	private Long id;
//	@ManyToOne
//	@JoinColumn(name = "ingred_product_ingredient_id",foreignKey = @ForeignKey(name="ingred_product_ingredient_id_fk"))
	private Ingredient ingredientId;
//	@ManyToOne
//	@JoinColumn(name = "ingred_product_product_id",foreignKey = @ForeignKey(name="ingred_product_product_id_fk"))
	private Product productId;
	
	public IngredProduct() {
		super();
	}
	public IngredProduct(Long id, Ingredient ingredientId, Product productId) {
		super();
		this.id = id;
		this.ingredientId = ingredientId;
		this.productId = productId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Ingredient getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(Ingredient ingredientId) {
		this.ingredientId = ingredientId;
	}
	public Product getProductId() {
		return productId;
	}
	public void setProductId(Product productId) {
		this.productId = productId;
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
		IngredProduct other = (IngredProduct) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
