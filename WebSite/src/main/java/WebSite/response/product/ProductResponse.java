package WebSite.response.product;

import java.util.Set;

import org.springframework.beans.BeanUtils;

import WebSite.entities.CategoryProduct;
import WebSite.entities.Evaluation;
import WebSite.entities.IngredProd;
import WebSite.entities.Product;
import WebSite.response.ingredient.IngredientResponse;

public class ProductResponse {
	private Long id;
	private String title;
	private Double price;
	private String description;
	private String image;
	
	
	
	
	public ProductResponse() {
	}

	public ProductResponse(Product product) {
		BeanUtils.copyProperties(product, this);
		System.out.println("iciiiiiiiiiiiiiiiii"+product.getEvaluations().toString());
		
		
		
		
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
