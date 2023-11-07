package WebSite.response.category;

import org.springframework.beans.BeanUtils;

import WebSite.entities.Category;

public class CategoryResponse {
	private Long id;
	private String title;
	private String vignette;
	
	public CategoryResponse() {
		
	}
	
	public CategoryResponse(Category category) {
		BeanUtils.copyProperties(category, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVignette() {
		return vignette;
	}

	public void setVignette(String vignette) {
		this.vignette = vignette;
	}
	
	
}
