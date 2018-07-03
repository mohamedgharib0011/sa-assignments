package webshop.product.domain;

/**
 * Review (Value Object)
 * 
 * @author mbeshir
 *
 */
public final class Review {

	private String title;

	private String description;

	private Integer rate;

	public Review(String title, String description, Integer rate) {
		super();
		this.title = title;
		this.description = description;
		this.rate = rate;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Integer getRate() {
		return rate;
	}

}
