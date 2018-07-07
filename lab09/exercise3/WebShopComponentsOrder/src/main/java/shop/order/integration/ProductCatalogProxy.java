package shop.order.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Component
public class ProductCatalogProxy {
	@Autowired
	ProductFeignClient productFeignClient;
	
	public void updateStock(String productNumber, int quantity) {
		productFeignClient.updateStock(productNumber, quantity);
	};
	
	
	@FeignClient("PRODUCT")
	interface ProductFeignClient {
		@RequestMapping(value = "/updateStock/{productNumber}/{quantity}", method=RequestMethod.POST)
		void updateStock(@PathVariable("productNumber") String productNumber, @PathVariable("quantity") Integer quantity);
	}
}
