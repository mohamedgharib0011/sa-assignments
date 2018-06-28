package greeting.controllers;

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

import greeting.models.Product;
import greeting.models.Stock;
import greeting.services.ProductCategoryService;

@RestController
@RequestMapping("/productcategory")
public class ProductCategoryController {
	@Autowired
	ProductCategoryService productCategoryService;

	@PostMapping
	public ResponseEntity<Void> addProduct(@RequestBody Product book) {
		productCategoryService.addProduct(book.getNum(), book.getDesc(), book.getPrice());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/{productnumber}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer productnumber) {
		return new ResponseEntity<Product>(productCategoryService.getProduct(productnumber), HttpStatus.OK);
	}

	@PutMapping("/{productnumber}/stock")
	public ResponseEntity<Void> setStock(@PathVariable() Integer productnumber, @RequestBody Stock stock) {
		productCategoryService.setStock(productnumber, stock.getQuantity(), stock.getLocationCode());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
