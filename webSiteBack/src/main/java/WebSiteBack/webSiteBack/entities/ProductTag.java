package WebSiteBack.webSiteBack.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product_tag")
public class ProductTag {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="product_tag_id")
	private Long id;
	@Column(name="product_tag_tag_id")
	private Long tagId;
	@Column(name="product_tag_product_id")
	private Long productId;
	

}
