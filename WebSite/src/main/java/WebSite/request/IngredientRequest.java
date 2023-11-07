package WebSite.request;

import org.springframework.beans.BeanUtils;

import WebSite.entities.Ingredient;

public class IngredientRequest {
	private Long id;
	private String name;
	private Long produitId;
	
	public IngredientRequest() {
		
	}
	
	public Ingredient toIngredientEntity() {
		Ingredient i=new Ingredient();
		BeanUtils.copyProperties(this, i);
		return i;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getProduitId() {
		return produitId;
	}

	public void setProduitId(Long produitId) {
		this.produitId = produitId;
	}
	
	
	
}
