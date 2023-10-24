package WebSite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebSite.entities.IngredProd;
import WebSite.entities.Ingredient;
import WebSite.entities.Product;
import WebSite.repositories.IngredProdRepository;

@Service
public class IngredProdService {
	
	@Autowired
	private IngredProdRepository ingredProdRepo;
	
	public IngredProd create(IngredProd ingredProd) {
		if(ingredProd==null) {
			throw new RuntimeException("ingredProd is null");
		}
		if(ingredProd.getId()==null) {
			throw new RuntimeException("id is null");
		}
		if(ingredProd.getIngredient()==null || ingredProd.getProduct()==null) {
			throw new RuntimeException("ingredient or product is null");
		}
		return ingredProdRepo.save(ingredProd);
	}
	
	public List<IngredProd> findByIngredient(Ingredient ingredient) {
		if(ingredient==null) {
			throw new RuntimeException("ingredient is null");
		}
		if(ingredient.getId()==null) {
			throw new RuntimeException("id is null");
		}
		return ingredProdRepo.findByIngredient(ingredient);
	}
	
	public List<IngredProd> findByIngredient(Product product) {
		if(product==null) {
			throw new RuntimeException("ingredient is null");
		}
		if(product.getId()==null) {
			throw new RuntimeException("id is null");
		}
		return ingredProdRepo.findByProduct(product);
	}
	
	public IngredProd findByIngredientIdAndProductId(Long ingredientId,Long productId) {
		if(ingredientId==null || productId==null) {
			throw new RuntimeException("ingredient id or product id is null");
		}
		return ingredProdRepo.findByIngredientIdAndProductId(ingredientId, productId).orElseThrow(()->{
			throw new RuntimeException("ingredientId or productId unknown");
		});
	}
	public IngredProd findByIngredientAndProduct(Ingredient ingredient, Product product) {
		if(ingredient==null || product==null) {
			throw new RuntimeException("ingredient or product is null");
		}
		if(ingredient.getId()==null || product.getId()==null) {
			throw new RuntimeException("ingredient id or product id is null");
		}
		return ingredProdRepo.findByIngredientAndProduct(ingredient, product).orElseThrow(()->{
			throw new RuntimeException("ingredient or product unknown");
		});
	}
}
