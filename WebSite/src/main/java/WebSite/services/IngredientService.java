package WebSite.services;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebSite.entities.Ingredient;
import WebSite.repositories.IngredientRepository;

@Service
public class IngredientService {
	@Autowired
	private IngredientRepository ingredRepo;
	
	public Ingredient create(Ingredient ingredient) {
		if(ingredient==null) {
			throw new RuntimeException("ingredient is null");
		}
		if(ingredient.getId()==null) {
			throw new RuntimeException("id is null");
		}
		if(ingredient.getProduits()==null) {
			throw new RuntimeException("produit is null");
		}
		if(ingredient.getName()==null) {
			throw new RuntimeException("name is null");
		}
		return ingredRepo.save(ingredient);
	}
	
	public Ingredient findByName(String name) {
		if(name==null) {
			throw new RuntimeException("name is null ");
		}
		return ingredRepo.findByName(name).orElseThrow(()->{
			throw new RuntimeException("name unknown");
		});
	}
	
	public List<Ingredient> findByNameContaining(String name){
		if(name==null) {
			throw new RuntimeException("name is null ");
		}
		return ingredRepo.findByNameContaining(name);
	}
	
	public Ingredient findByIdFetchProduits(Long id) {
		if(id==null) {
			throw new RuntimeException("id cannot be null");
		}
		return ingredRepo.findByIdFecthProduits(id);
	}
}
