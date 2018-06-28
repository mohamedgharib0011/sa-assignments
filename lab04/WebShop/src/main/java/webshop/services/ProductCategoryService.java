package webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshop.models.product.Product;
import webshop.models.product.Stock;
import webshop.repositories.ProductCategoryRepository;

/** 
 * 
 * @author mbeshir
 *
 */
@Service
public class ProductCategoryService {

	@Autowired
	ProductCategoryRepository productCategoryRepository;

	public void addProduct(Integer productnumber,String name, String description, double price) {
		productCategoryRepository.save(new Product(productnumber,name, description, price));
	}

	public Product getProduct(Integer productnumber) {
		return productCategoryRepository.findById(productnumber).orElse(null);
	}

	
	public void setStock(Integer productnumber, Integer quantity, Integer locationcode) {
		productCategoryRepository.findById(productnumber).ifPresent(p -> {
			p.setStock(new Stock(quantity, locationcode));
			productCategoryRepository.save(p);
		});

	}

}
