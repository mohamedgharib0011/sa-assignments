package webshop;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import webshop.models.order.Order;
import webshop.models.product.Product;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {

	@Autowired
	private RestOperations retTemplate;

	public static void main(String[] args) {
		SpringApplication.run(WebShopApplication.class, args);
	}

	@Bean
	RestTemplate retTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters()
				.addAll(Arrays.asList(new MappingJackson2HttpMessageConverter(), new StringHttpMessageConverter()));
		return restTemplate;
	}

	@Override
	public void run(String... args) throws Exception {

		// create product 1
		HttpEntity<Product> productRequest = new HttpEntity<>(new Product(10, "Product1", "Product1", 33));
		retTemplate.postForObject("http://localhost:8080/productcategory", productRequest, Void.class);

		// create product 2
		HttpEntity<Product> productRequest2 = new HttpEntity<>(new Product(11, "Product2", "Product2", 44));
		retTemplate.postForObject("http://localhost:8080/productcategory", productRequest2, Void.class);

		// create shopping card 3
		retTemplate.postForObject("http://localhost:8080/shoppingcart/3", null, Void.class);

		// add product 10 with quantity 3 to shopping card 3
		retTemplate.put("http://localhost:8080/shoppingcart/newproduct/10/3/3", null);

		// add product 11 with quantity 2 to shopping card 3
		retTemplate.put("http://localhost:8080/shoppingcart/newproduct/11/2/3", null);

		// checkout shopping card 3
		retTemplate.postForObject("http://localhost:8080/shoppingcart/checkout/3", null, Void.class);

		// retrieve order 3
		Order order = retTemplate.getForObject("http://localhost:8080/order/3", Order.class);

		System.out.println("Order:" + order);

	}

}
