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
import jakarta.persistence.Transient;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long id;
	@Column(name="product_title",unique = true ,nullable = false)
	private String title;
	@Column(name="product_price",nullable = false)
	private Double price;
	@Column(name="product_description",columnDefinition = "TEXT")
	private String description;
	@Column(name="product_image",columnDefinition = "LONGBLOB")
	private byte[] image;
	@Transient
	private Double avgRating;
	@OneToMany(mappedBy = "product")
	private Set<IngredProd> ingredients;
	@OneToMany(mappedBy = "product")
	private Set<Evaluation> evaluations;
	@OneToMany(mappedBy = "product")
	private Set<CategoryProduct> categories;
	
	
	public Product() {
		super();
	}


	public Product(Long id, String title, String description, Set<Evaluation> evaluations) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.evaluations = evaluations;
	}
	
	public void evaluationRatingAvg() {
		if(!evaluations.isEmpty()) {
			evaluations.stream().map(e->e.getRating()).forEach(r->{avgRating+=r;});
			avgRating/=evaluations.size();
		}
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


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public Set<IngredProd> getIngredients() {
		return ingredients;
	}


	public void setIngredients(Set<IngredProd> ingredients) {
		this.ingredients = ingredients;
	}


	

	public Set<CategoryProduct> getCategories() {
		return categories;
	}


	public void setCategories(Set<CategoryProduct> categories) {
		this.categories = categories;
	}


	public Double getAvgRating() {
		return avgRating;
	}


	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
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
