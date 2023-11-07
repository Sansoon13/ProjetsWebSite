package WebSite.response.product;

import java.util.List;

import WebSite.entities.Product;
import WebSite.response.category.CategoryResponse;

public class ProductWithCategoryResponse extends ProductResponse {

	private List<CategoryResponse> categories;
	
	public ProductWithCategoryResponse(Product product) {
		super(product);
		this.categories=product.getCategories().stream().map(c->{
			return new CategoryResponse(c.getcategory());
		}).toList();
	}

	public List<CategoryResponse> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryResponse> categories) {
		this.categories = categories;
	}
	
	
	
}
