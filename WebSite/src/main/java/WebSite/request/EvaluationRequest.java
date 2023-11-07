package WebSite.request;

import org.springframework.beans.BeanUtils;

import WebSite.entities.Evaluation;

public class EvaluationRequest {
	
	private Long rating;
	private String comment;
	private Long authorId;
	private Long productId;
	
	public EvaluationRequest() {
		
	}
	
	public Evaluation toEvaluationEntity() {
		Evaluation e=new Evaluation();
		BeanUtils.copyProperties(this, e);
		return e;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	
}
