package WebSite.response.ingredient;

import java.util.List;

import WebSite.entities.Ingredient;
import WebSite.response.product.ProductResponse;

public class IngredientWithProductResponse extends IngredientResponse{
	
	private List<ProductResponse> produits;
	
	public IngredientWithProductResponse(Ingredient ingredient) {
		this.produits=ingredient.getProduits().stream().map(p->
		new ProductResponse(p.getProduct())).toList();
	}

	public List<ProductResponse> getProduits() {
		return produits;
	}

	public void setProduits(List<ProductResponse> produits) {
		this.produits = produits;
	}
	
	
	 
}
