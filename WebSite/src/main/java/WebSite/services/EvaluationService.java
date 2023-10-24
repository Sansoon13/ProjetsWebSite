package WebSite.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebSite.entities.Evaluation;
import WebSite.entities.Product;
import WebSite.entities.User;
import WebSite.repositories.EvaluationRepository;

@Service
public class EvaluationService {

	@Autowired
	private EvaluationRepository evalRepo;
	
	public Evaluation create(Evaluation evaluation) {
		if(evaluation==null) {
			throw new RuntimeException("evaluation cannnot be null");
		}
		if(evaluation.getRating()==0) {
			throw new RuntimeException("rating cannot be null");
		}
		if(evaluation.getAuthor()==null || evaluation.getProduct()==null) {
			throw new RuntimeException("author or product is null");
		}
		return evalRepo.save(evaluation);
	}
	
	public List<Evaluation> findByAuthor(User author){
		if(author==null) {
			throw new RuntimeException("author cannot be null");
		}
		if(author.getId()==null) {
			throw new RuntimeException("id is null");
		}
		return evalRepo.findByAuthor(author);
	}
	
	public List<Evaluation> findByProduct(Product product){
		if(product==null) {
			throw new RuntimeException("product is null");
		}
		if(product.getId()==null) {
			throw new RuntimeException("id of product cannot be null");
		}
		return evalRepo.findByProduct(product);
	}
	
	public Evaluation findById(Long id) {
		if(id==null) {
			throw new RuntimeException("id is null");
		}
		return evalRepo.findById(id).orElseThrow(()->{
			throw new RuntimeException("unknown id");
		});
	}
	
	
	
	
}
