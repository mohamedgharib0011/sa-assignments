package webshop.product.service.dto;

/**
 * used for adding review for product
 * 
 * @author mbeshir
 *
 */
public class ReviewDTO {

	private String title;

	private String description;

	private Integer rate;

	public ReviewDTO() {
		super();
	}

	public ReviewDTO(String title, String description, Integer rate) {
		super();
		this.title = title;
		this.description = description;
		this.rate = rate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

}
