package WebSite.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import WebSite.entities.Ingredient;
import WebSite.response.ingredient.IngredientResponse;
import WebSite.response.ingredient.IngredientWithProductResponse;
import WebSite.services.IngredientService;

@RestController
@RequestMapping("/api/ingredient")
@CrossOrigin(origins = "*")
public class IngredientRestController {

	@Autowired
	private IngredientService ingSrv;
	
	@GetMapping("/all")
	public List<IngredientResponse> findAll(){
		return ingSrv.findAll().stream().map(IngredientResponse::new).toList();
	} 
	
	@GetMapping("/base/{name}")
	public IngredientWithProductResponse findByIngredient(@PathVariable String name) {
		Ingredient ingredient=ingSrv.findByName(name);
		IngredientWithProductResponse ingR=new IngredientWithProductResponse(ingredient);
		return ingR;
	}
	
	@GetMapping("/ingredient/{name}")
	public IngredientResponse findByName(@PathVariable String name) {
		Ingredient ingredient=ingSrv.findByName(name);
		return new IngredientResponse(ingredient);
		
	}
	
}
