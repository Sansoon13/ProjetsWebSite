package WebSite.restController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import WebSite.entities.Product;
import WebSite.response.product.ProductResponse;
import WebSite.response.product.ProductWithCategoryResponse;
import WebSite.response.product.ProductWithEvaluationResponse;
import WebSite.response.product.ProductWithIngredientsResponse;
import WebSite.services.ProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/product")
public class ProductRestController {
	private static final Logger log = LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	private ProductService prodSrv;
	
	@GetMapping("/{id}")
	public ProductResponse findById(@PathVariable Long id) {
		Product foundproduct=prodSrv.findById(id);
		if(foundproduct==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return new ProductResponse(foundproduct);
	}
	
	@GetMapping("ingredients/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductWithIngredientsResponse findByIdWithIngredients(@PathVariable Long id) {
		Product foundProduct=prodSrv.findByIdWithIngredients(id);
		ProductWithIngredientsResponse productIng=new ProductWithIngredientsResponse(foundProduct);
		return productIng;
	}
	
	@GetMapping("evaluations/{id}")
	public ProductWithEvaluationResponse findByIdWithEvaluation(@PathVariable Long id) {
		Product product=prodSrv.findByIdWithEvaluations(id);
		log.info(product.getEvaluations().toString());
		ProductWithEvaluationResponse pR=new ProductWithEvaluationResponse(product);
		log.info(pR.getAvgRating().toString());
		
		return pR;
	}
	
	@GetMapping("categories/{id}")
	public ProductWithCategoryResponse findByIdWithCategories(@PathVariable Long id) {
		Product p=prodSrv.findByIdWithCategories(id);
		ProductWithCategoryResponse pR=new ProductWithCategoryResponse(p);
		return pR;
	}
	
	@GetMapping("/all")
	public List<ProductResponse> findAll() {
		return prodSrv.findAll().stream().map(ProductResponse::new).toList();
	}
	
	@GetMapping("/title:{title}")
	public List<ProductResponse> findAllTitleContaining(@PathVariable String title) {
		log.info("tilteeeeee"+title);
		return prodSrv.findByTitleContaining(title).stream().map(ProductResponse::new).toList();
		
	} 
	@GetMapping("/price/{priceLow}/{priceHigh}")
	public List<ProductResponse> findByPriceBetween(@PathVariable Double priceLow,@PathVariable Double priceHigh){
		log.info(priceLow.toString()+"priceeeeeee"+priceHigh.toString());
		return prodSrv.findByPriceBetween(priceLow, priceHigh).stream().map(ProductResponse::new).toList();
	}
	
	@GetMapping("/all/cat")
	public List<ProductWithCategoryResponse> getAllWithCat() {
		return prodSrv.findAllFetchCat().stream().map(ProductWithCategoryResponse::new).toList();
		
	}
}
		
