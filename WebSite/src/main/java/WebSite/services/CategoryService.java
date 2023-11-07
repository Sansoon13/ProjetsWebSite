package WebSite.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebSite.entities.Category;
import WebSite.entities.Product;
import WebSite.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository cateRepo;
	
	
	public Category create(Category category) {
		if(category==null) {
			throw new RuntimeException("category is null");
		}
		if(category.getId()==null) {
			throw new RuntimeException("id cannot be null");
		}
		if(category.getProducts()!=null) {
			throw new RuntimeException("product is null");
		}
		return cateRepo.save(category);
	}
	
	public Category findByTitle(String title){
		if(title==null || title.isBlank()) {
			throw new RuntimeException("title is null");
		}
		return cateRepo.findByTitle(title).orElseThrow(()->{
			throw new RuntimeException("unknown title");
		}
			
		);
			
		
	}
	
	public List<Category> findByTitleContaining(String title){
		if(title==null || title.isBlank()) {
			throw new RuntimeException("title is null");
		}
		return cateRepo.findByTitleContaining(title);
	}
	
	public Category findByIdWithProducts(Long id){
		if(id==null) {
			throw new RuntimeException("id is null");
		}
		return cateRepo.findByIdFetchProducts(id).orElseThrow(()->{
			throw new RuntimeException("unknown id");
		});
	}
	
	public List<Category> findByProducts(Product product) {
		if(product==null) {
			throw new RuntimeException("product is null");
		}
		if(product.getId()==null) {
			throw new RuntimeException("id is null");
		}
		return cateRepo.findByProducts(product);
		
	}
	
	public List<Category> findAll(){
		return cateRepo.findAll();
	}
	
	public Category findById(Long id) {
		if(id==null) {
			throw new RuntimeException("id cannot be null");
		}
		return cateRepo.findById(id).orElseThrow(()->{
			throw new RuntimeException("unknown Id");
		});
	}
	
	
	
}
