package WebSite.response.category;


import java.util.List;

import WebSite.entities.Category;
import WebSite.response.product.ProductResponse;

public class CategoryWithProductResponse extends CategoryResponse{

	
	private List<ProductResponse> produits;
	
	public CategoryWithProductResponse(Category category) {
		super(category);
		
		this.produits=category.getProducts().stream().map(cP->{
				return new ProductResponse(cP.getProduct());
			}).toList();
			
		}

	public List<ProductResponse> getProduits() {
		return produits;
	}

	public void setProduits(List<ProductResponse> produits) {
		this.produits = produits;
	} 

	
	
	
	
	
	
	}

	
	
	

