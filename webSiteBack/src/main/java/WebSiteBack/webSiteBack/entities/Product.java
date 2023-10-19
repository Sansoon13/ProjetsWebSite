package WebSiteBack.webSiteBack.entities;

import java.util.Objects;
import java.util.Set;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="product_id")
	private Long id;
	@NonNull
	@Column(name="product_title",nullable = false)
	private String title;
	@Column(name="product_image",nullable = false,columnDefinition = "TEXT")
	private String image;
	@Column(name="product_price")
	private String price;
	@Column(name="product_ingred_products")
	@OneToMany(mappedBy = "productId")
	private Set<IngredProduct> ingredProducts;
	@Column(name="product_description")
	private String description;
	@Column(name="product_evaluations")
	
	private Set<Evaluation> evaluations;
	
	@Column(name="product_product_tags")
	@OneToMany(mappedBy = "productId")
	private Set<ProductTag> productTags;
	
	public Product() {
		super();
	}
	
	public Product(Long id, String title, String image, String price, String description) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.price = price;
		this.description = description;
	}



	public Product(Long id, String title, String image, String price, String description, Set<Evaluation> evaluations) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.price = price;
		this.description = description;
		this.evaluations = evaluations;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
