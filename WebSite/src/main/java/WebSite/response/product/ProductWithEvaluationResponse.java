package WebSite.response.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import WebSite.entities.Product;
import WebSite.response.evaluation.EvaluationWithUserResponse;
import WebSite.restController.UserRestController;

public class ProductWithEvaluationResponse extends ProductResponse{
	private static final Logger log = LoggerFactory.getLogger(UserRestController.class);
	private Double avgRating=0.0;
	private List<EvaluationWithUserResponse> evaluations;
	
	public ProductWithEvaluationResponse(Product product) {
		super(product);
		
		if(!product.getEvaluations().isEmpty()) {
			this.evaluations=product.getEvaluations().stream().map(EvaluationWithUserResponse::new).toList();
			evaluationavgRating();
			System.out.println("response moyenne :"+this.avgRating);
		}
	}
	
	public void evaluationavgRating() {
		System.out.print("ici formule !");
		if(!evaluations.isEmpty()) {
			evaluations.stream().map(e->
				e.getRating()
			).forEach(r->{
				this.avgRating+=r;
			});
			this.avgRating/=evaluations.size();
			System.out.print(this.avgRating);
		}
	}

	public Double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}

	public List<EvaluationWithUserResponse> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<EvaluationWithUserResponse> evaluations) {
		this.evaluations = evaluations;
	}

	
	
	
	
}
