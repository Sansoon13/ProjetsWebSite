package WebSite.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="evaluation")
public class Evaluation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="evaluation_id")
	private Long id;
	@Column(name="evaluation_rating")
	private Double rating;
	@Column(name="evaluation_comment")
	private String comment;
	@ManyToOne
	@JoinColumn(name="evaluation_author_id",foreignKey = @ForeignKey(name="evaluation_author_id_fk"))
	private User author;
	@ManyToOne
	@JoinColumn(name="evaluation_product_id",foreignKey = @ForeignKey(name="evaluation_product_id_fk"))
	private Product product;
	
	public Evaluation() {
		super();
	}
	
	public Evaluation(Long id, Double rating, String comment, User author, Product product) {
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
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
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
