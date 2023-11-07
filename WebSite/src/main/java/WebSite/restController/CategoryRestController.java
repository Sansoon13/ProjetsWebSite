package WebSite.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import WebSite.entities.Category;
import WebSite.response.category.CategoryResponse;
import WebSite.response.category.CategoryWithProductResponse;
import WebSite.services.CategoryService;

@RestController
@RequestMapping("api/categories")
@CrossOrigin(origins = "*")
public class CategoryRestController {
	@Autowired
	private CategoryService cSrv;
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<CategoryResponse> getAll(){
		return cSrv.findAll().stream().map(CategoryResponse::new).toList();
	}
	
	@GetMapping("/title/{title}")
	public CategoryWithProductResponse getByTag(@PathVariable String title){
		System.out.println("titleeee "+title);
		Category cat=cSrv.findByTitle(title);
		
		CategoryWithProductResponse cR=new CategoryWithProductResponse(cat);
		return cR;
	}
	
	@GetMapping("/id/{id}")
	public CategoryWithProductResponse getByIdWithProduct(@PathVariable Long id){
		Category c=cSrv.findById(id);
		CategoryWithProductResponse cR=new CategoryWithProductResponse(c);
		return cR;
	
	
	}
	}
