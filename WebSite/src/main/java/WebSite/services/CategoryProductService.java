package WebSite.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebSite.entities.Category;
import WebSite.entities.CategoryProduct;
import WebSite.entities.Product;
import WebSite.repositories.CategoryProductRepository;

@Service
public class CategoryProductService {
	@Autowired
	private CategoryProductRepository cateProdRepo;
	
	public CategoryProduct create(CategoryProduct categoryProduct) {
		if(categoryProduct==null) {
			throw new RuntimeException("categoryProduct is null");
		}
		if(categoryProduct.getId()==null) {
			throw new RuntimeException("id is null");
		}
		if(categoryProduct.getcategory()==null && categoryProduct.getProduct()==null) {
			throw new RuntimeException("category or product is null");
		}
		return cateProdRepo.save(categoryProduct);
	}
	
	public List<CategoryProduct> findByCategory(Category category) {
		if(category==null) {
			throw new RuntimeException("category is null");
		}
		if(category.getId()==null) {
			throw new RuntimeException("id is null");
		}
		return cateProdRepo.findByCategory(category);
	}
	
	public List<CategoryProduct> findByProduct(Product product){
		if(product==null) {
			throw new RuntimeException("product is null");
		}
		if(product.getId()==null) {
			throw new RuntimeException("product id is null");
		}
		return cateProdRepo.findByProduct(product);
	}
	
	public List<CategoryProduct> findByCategoryAndProduct(Category category,Product product){
		if(category==null) {
			throw new RuntimeException("category is null");
		}
		if(category.getId()==null || category.getId()==null) {
			throw new RuntimeException("category id is null");
		}
		return cateProdRepo.findByCategoryAndProduct(category, product);
	}
	
	
}
