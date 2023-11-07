package WebSite.response.product;

import java.util.List;

import WebSite.entities.IngredProd;
import WebSite.entities.Product;
import WebSite.response.ingredient.IngredientResponse;

public class ProductWithIngredientsResponse extends ProductResponse{
	
	private List<IngredientResponse> ingredients;
	
	public ProductWithIngredientsResponse(Product product) {
		super(product);
		this.ingredients=product.getIngredients().stream().map(pIn->{
			return new IngredientResponse(pIn.getIngredient());
		}).toList();
	}


	public List<IngredientResponse> getIngredients() {
		return ingredients;
	}


	public void setIngredients(List<IngredientResponse> ingredients) {
		this.ingredients = ingredients;
	}

	
	
	
}
