package WebSite.entities;

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
@Table(name="categoryproduct")
public class CategoryProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="categoryproduct_id")
	private Long id;
	@ManyToOne
	@JoinColumn(name="categoryproduct_product_id",foreignKey = @ForeignKey(name="categoryproduct_product_id_fk"))
	private Product product;
	@ManyToOne
	@JoinColumn(name="categoryproduct_category_id",foreignKey = @ForeignKey(name="categoryproduct_category_id_fk"))
	private Category category;
	
	public CategoryProduct() {
		super();
	}
	
	
	
	public CategoryProduct(Long id, Product product, Category category) {
		super();
		this.id = id;
		this.product = product;
		this.category = category;
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
	public Category getcategory() {
		return category;
	}
	public void setcategory(Category category) {
		this.category = category;
	}
	
	

}
