package WebSite.response.evaluation;

import org.springframework.beans.BeanUtils;

import WebSite.entities.Evaluation;
import WebSite.entities.Product;
import WebSite.entities.User;
import WebSite.response.user.UserResponse;

public class EvaluationResponse {

	private Long id;
	private int rating;
	private String comment;
	
	
	public EvaluationResponse() {
	}
	
	public EvaluationResponse(Evaluation evaluation) {
		BeanUtils.copyProperties(evaluation, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	
	
}
