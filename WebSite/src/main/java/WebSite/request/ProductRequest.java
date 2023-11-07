package WebSite.request;

import java.util.Set;

import org.springframework.beans.BeanUtils;

import WebSite.entities.CategoryProduct;
import WebSite.entities.Evaluation;
import WebSite.entities.IngredProd;
import WebSite.entities.Product;

public class ProductRequest {
	private String title;
	private Double price;
	private String description;
	private String image;
//	private Long evaluationId;
//	private Long ingredientId;
//	private Long categorieId;
	
	public ProductRequest() {
		
	}
	
	public Product toProductEntity() {
		Product product=new Product();
		BeanUtils.copyProperties(this, product);
		return product;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	
	
	
}
