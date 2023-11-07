package WebSite.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
	private Long id;
	@Column(name="category_title")
	private String title;
	@Column(name="category_vignette")
	private String vignette;
	@OneToMany(mappedBy = "category")
	private Set<CategoryProduct> products;
	
	public Category() {
		super();
	}
	public Category(Long id, String title, String vignette, Set<CategoryProduct> products) {
		super();
		this.id = id;
		this.title = title;
		this.vignette = vignette;
		this.products = products;
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
	
	public String getVignette() {
		return vignette;
	}
	public void setVignette(String vignette) {
		this.vignette = vignette;
	}
	public Set<CategoryProduct> getProducts() {
		return products;
	}
	public void setProducts(Set<CategoryProduct> products) {
		this.products=products;
	}
	
	
}
