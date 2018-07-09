package shop.shopping.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.shopping.service.ProductDTO;

@Component
public class ProductCatalogProxy {
	@Autowired
	ProductFeignClient productFeignClient;

	public ProductDTO getProduct(String productnumber) {
		return productFeignClient.getProduct();
	};

	@FeignClient("PRODUCT")
	interface ProductFeignClient {
		@RequestMapping(value = "/product/A33")
		ProductDTO getProduct();
	}
}
