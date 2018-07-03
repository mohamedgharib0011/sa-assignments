package webshop.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import webshop.product.domain.Product;
import webshop.product.domain.Review;
import webshop.product.domain.Stock;
import webshop.product.repository.ProductRepository;
import webshop.product.service.dto.ProductDTO;
import webshop.product.service.dto.ReviewDTO;
import webshop.product.service.dto.SimpleProductDTO;
import webshop.product.service.event.NewProductEvent;

/**
 * product reception
 * 
 * @author mbeshir
 *
 */
@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	@Autowired
	ApplicationEventPublisher eventPublisher;

	private Stock stock;

	/**
	 * add new product then publish new product event
	 * 
	 * @param productDTO
	 */
	public void addProduct(ProductDTO productDTO) {
		Product product = new Product(productDTO.getProductNumber(), productDTO.getName(), productDTO.getDescription(),
				productDTO.getPrice(), productDTO.getSupplierNumber());
		product = productRepository.save(product);

		eventPublisher.publishEvent(
				new NewProductEvent("new product event for product number: " + productDTO.getProductNumber()));

	}

	/**
	 * user for decreasing the product stock when a product confirmed
	 * 
	 * @param productNumber
	 * @param quantity:
	 *            amount to be decreased
	 */
	public void decreaseProductStock(String productNumber, int quantity) {
		productRepository.findById(productNumber).ifPresent(product -> {
			stock = product.getStock();
			if (stock != null)
				stock.decreaseStock(quantity);
			productRepository.save(product);
		});
	}

	/**
	 * get simple product by number
	 * 
	 * @param productnumber
	 * @return {@link SimpleProductDTO}
	 */
	public SimpleProductDTO getSimpleProduct(String productnumber) {
		Optional<Product> result = productRepository.findById(productnumber);
		if (result.isPresent()) {
			Product product = result.get();
			Stock stock = product.getStock();
			int stockAmount=stock!=null?stock.getQuantity():0;
			return new SimpleProductDTO(product.getProductNumber(), product.getName(), product.getPrice(),stockAmount);
		} else
			return null;
	}


	/**
	 * add stock information to a certain product
	 * 
	 * @param productnumber
	 * @param quantity
	 * @param locationcode
	 */
	public void setProductStock(String productnumber, int quantity, String locationcode) {
		productRepository.findById(productnumber).ifPresent(product -> {
			Stock stock = new Stock(quantity, locationcode);
			product.setStock(stock);
			productRepository.save(product);
		});
	}

	/**
	 * add new review to certain product
	 * 
	 * @param productnumber
	 * @param reviewDTO
	 */
	public void addProductReview(String productnumber, ReviewDTO reviewDTO) {
		productRepository.findById(productnumber).ifPresent(product -> {
			product.getReviews().add(new Review(reviewDTO.getTitle(), reviewDTO.getDescription(), reviewDTO.getRate()));
			productRepository.save(product);
		});
	}

}
