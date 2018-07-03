package webshop.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webshop.product.service.ProductService;
import webshop.product.service.dto.ProductDTO;
import webshop.product.service.dto.ReviewDTO;
import webshop.product.service.dto.SimpleProductDTO;

/**
 * 
 * @author mbeshir
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/{productNumber}/simple")
	public ResponseEntity<?> getProduct(@PathVariable String productNumber) {
		return new ResponseEntity<SimpleProductDTO>(productService.getSimpleProduct(productNumber),
				HttpStatus.OK);
	}

	@PostMapping(value = "")
	public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO) {
		productService.addProduct(productDTO);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/{productNumber}/stock/{quantity}/{locationcode}")
	public ResponseEntity<?> setStock(@PathVariable String productNumber, @PathVariable int quantity,
			@PathVariable String locationcode) {
		productService.setProductStock(productNumber, quantity, locationcode);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping( "/{productNumber}/review")
	public ResponseEntity<?> addReview(@RequestBody ReviewDTO reviewDTO, @PathVariable String productNumber) {
		productService.addProductReview(productNumber, reviewDTO);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
