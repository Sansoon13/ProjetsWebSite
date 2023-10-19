package WebSiteBack.webSiteBack.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="evaluation")
public class Evaluation {
	private Long id;
	private String rating;
	private String comment;
	@ManyToOne
	private User author;
	@ManyToOne
	private Product product;
	
	public Evaluation() {
		super();
	}
	
	public Evaluation(Long id, String rating, String comment, User author, Product product) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.author = author;
		this.product = product;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evaluation other = (Evaluation) obj;
		return Objects.equals(id, other.id);
	}
	
}
