package WebSite.response.evaluation;

import WebSite.entities.Evaluation;
import WebSite.response.user.UserResponse;

public class EvaluationWithUserResponse extends EvaluationResponse {
	
	private UserResponse user;
	
	public EvaluationWithUserResponse(Evaluation evaluation) {
		super(evaluation);
		this.setUser(new UserResponse(evaluation.getAuthor()));
	}

	public UserResponse getUser() {
		return user;
	}

	public void setUser(UserResponse user) {
		this.user = user;
	}
	
	

}
