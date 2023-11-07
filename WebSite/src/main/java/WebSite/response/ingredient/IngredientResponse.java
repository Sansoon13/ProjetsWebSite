package WebSite.response.ingredient;

import java.util.Set;

import org.springframework.beans.BeanUtils;

import WebSite.entities.IngredProd;
import WebSite.entities.Ingredient;

public class IngredientResponse {
	private String name;
	
	public IngredientResponse() {
		
	}
	
	public IngredientResponse(Ingredient ingredient) {
		BeanUtils.copyProperties(ingredient, this);
	}

	public String getName() {
		return name;
	} 

	public void setName(String name) {
		this.name = name;
	}

	
	

}
