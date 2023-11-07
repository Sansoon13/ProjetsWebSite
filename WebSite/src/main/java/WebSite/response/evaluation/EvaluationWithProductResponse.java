package WebSite.response.evaluation;

import WebSite.entities.Evaluation;
import WebSite.response.product.ProductResponse;

public class EvaluationWithProductResponse extends EvaluationResponse {

	private ProductResponse product;
	
	public EvaluationWithProductResponse(Evaluation evaluation) {
		super(evaluation);
		this.setProduct(new ProductResponse(evaluation.getProduct()));
		
	}

	public ProductResponse getProduct() {
		return product;
	}

	public void setProduct(ProductResponse product) {
		this.product = product;
	}
	
	
	
}
