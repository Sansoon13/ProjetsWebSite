package WebSite.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import WebSite.entities.Category;
import WebSite.entities.Evaluation;
import WebSite.entities.Product;
import WebSite.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	
	public Product create(Product product) {
		if(product==null) {
			
		}
		if(product.getTitle()==null || product.getTitle().isBlank()) {
			
		}else {
			Optional<Product> optProduct=productRepo.findByTitle(product.getTitle());
			if(optProduct.isPresent()) {
				throw new RuntimeException("product already exist,title taken");
			}
		}
		return productRepo.save(product);
	}
	
	public Product update(Product product) {
		if(product.getId()==null) {
			throw new RuntimeException("this id : "+product.getId()+" is unknown");
		}
		Optional<Product> optProduct=productRepo.findById(product.getId());
		if(optProduct.isPresent()) {
			Product foundProd=optProduct.get();
			if(foundProd.getTitle().isEmpty() && !foundProd.getTitle().equals(product.getTitle())) {
				foundProd.setTitle(product.getTitle());
				return productRepo.save(foundProd);
			}
			throw new RuntimeException("title already taken");
		}
		throw new RuntimeException("this product id is unknown");
	
	}
	public List<Product> findAll(){
		return productRepo.findAll();
	}
	
	public List<Product> findAllFetchEvaluations(){
		return productRepo.findAllFetchEvaluations();
	}
	
	public List<Product> findAllFetchEvaluationsAndIngredients(){
		return productRepo.findAllFetchEvaluationsAndIngredients();
	}
	
	public Product findById(Long id) {
		if(id==null) {
			throw new RuntimeException("id cannot be null");
		}
		return productRepo.findById(id).orElseThrow(()->{
			throw new RuntimeException("id unknown");
		});
	}
	
	public Product findByIdWithEvaluations(Long id){
		if(id==null) {
			throw new RuntimeException("id cannot be null");
		}
		return productRepo.findByIdFetchEvaluations(id).orElseThrow(()->{
			throw new RuntimeException("id unkonw");
		});
	}
	
	public Product findByIdWithIngredients(Long id) {
		if(id==null) {
			throw new RuntimeException("id cannot be null");
		}
		return productRepo.findByIdFetchIngredients(id).orElseThrow(()->{
			throw new RuntimeException("unkown id");
		});
	}
	
	public Product findByIdWithCategories(Long id) {
		if(id==null) {
			throw new RuntimeException("id cannot be null");
		}
		return productRepo.findByIdFetchCategories(id).orElseThrow(()->{
			throw new RuntimeException("unkown id");
		} );
	}
	
	public Product findByIdWithAll(Long id) {
		if(id==null) {
			throw new RuntimeException("id cannot be null");
		}
		return productRepo.findByIdFetchAll(id).orElseThrow(()->{
			throw new RuntimeException("unknown id");
		});
	}
	
	public Set<Product> findByTitleContaining(String title){
		if(title==null) {
			throw new RuntimeException("title cannot be null");
		}
		return productRepo.findByTitleContaining(title);
	}
	
	public Optional<Product> findByTitle(String title){
		if(title==null) {
			throw new RuntimeException("title cannot be null");
		}
		return productRepo.findByTitle(title);
	}
	
	public Set<Product> findByPriceBetween(double priceLow,double priceHigh){
		if(priceLow>priceHigh) {
			throw new RuntimeException("priceLow > priceHigh");
		}
		if(priceHigh<priceLow) {
			throw new RuntimeException("priceHigh<priceLow");
		}
		return productRepo.findByPriceBetween(priceLow, priceHigh);
		
	}
	public Set<Product> findByAvgRating(double avgRating){
		if(avgRating>5 || avgRating<1){
			throw new RuntimeException("invalid rating");
		}
		return productRepo.findByAvgRating(avgRating);
	}
	
//	public Set<Product> findByEvaluations(Evaluation evaluation){
//		if(evaluation == null) {
//			throw new RuntimeException("evaluation cannot be null");
//		}
//		return productRepo.findByEvaluations(evaluation);
//	}
	
	public Set<Product> findByCategory(Category category){
		if(category==null) {
			throw new RuntimeException("category cannot be null");
		}
		return productRepo.findByCategories(category);
	}
	
	
}
	

