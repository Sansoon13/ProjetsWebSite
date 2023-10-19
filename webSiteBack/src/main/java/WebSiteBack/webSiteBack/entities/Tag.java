package WebSiteBack.webSiteBack.entities;

import java.util.Set;

import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tag")
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="tag_id",nullable = false)
	private Long id;
	@Column(name="tag_name",nullable = false)
	private String name;
	@Column(name="tag_product_tags")
	private Set<ProductTag> productTags;
	
	public Tag() {
		super();
	}

	public Tag(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	
	

}
