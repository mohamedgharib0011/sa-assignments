package webshop;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import webshop.customer.service.CustomerService;
import webshop.customer.service.dto.CustomerDTO;
import webshop.order.service.dto.AddressDTO;
import webshop.order.service.dto.CreditCardDTO;
import webshop.order.service.dto.OrderDTO;
import webshop.order.service.dto.ShippingOptionDTO;
import webshop.product.service.dto.ProductDTO;
import webshop.product.service.dto.ReviewDTO;
import webshop.shared.dto.SimpleProductDTO;

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
		HttpEntity<ProductDTO> productRequest = new HttpEntity<>(new ProductDTO("1", 33, "Product1", "Product1"));
		retTemplate.postForObject("http://localhost:8083/product", productRequest, Void.class);

		// create product 2
		HttpEntity<ProductDTO> productRequest2 = new HttpEntity<>(new ProductDTO("2", 44, "Product2", "Product2"));
		retTemplate.postForObject("http://localhost:8083/product", productRequest2, Void.class);

		/// {productNumber}/review
		retTemplate.put("http://localhost:8083/product/1/review", new ReviewDTO("Review1", "This is Review #1 ", 9));
		retTemplate.put("http://localhost:8083/product/1/review", new ReviewDTO("Review2", "This is Review #2 ", 8));

		// set product 1 stock info (quantity:30, locationCode:777)
		retTemplate.put("http://localhost:8083/product/1/stock/30/777", null);

		// set product 2 stock info (quantity:20, locationCode:777)
		retTemplate.put("http://localhost:8083/product/2/stock/20/777", null);

		// fetch product 1
		SimpleProductDTO prod1 = retTemplate.getForObject("http://localhost:8083/product/1/simple", SimpleProductDTO.class);

		// fetch product 2
		SimpleProductDTO prod2 = retTemplate.getForObject("http://localhost:8083/product/2/simple", SimpleProductDTO.class);

		// add product 1 with quantity 2 to shopping card 1
		retTemplate.put("http://localhost:8084/shoppingcart/1/2", new HttpEntity<SimpleProductDTO>(prod1));

		// add product 1 with quantity 3 to shopping card 1
		retTemplate.put("http://localhost:8084/shoppingcart/1/3", new HttpEntity<SimpleProductDTO>(prod2));

		// checkout shopping card 1
		retTemplate.put("http://localhost:8084/shoppingcart/checkout/1", null, Void.class);

		// add initial customer with number 111
		HttpEntity<CustomerDTO> customer = new HttpEntity<>(new CustomerDTO("1", "Mohamed", "Gharib", "mgharib@mum.edu", "123333"));
		retTemplate.postForObject("http://localhost:8081/customer", customer, Void.class);

		// set customer 111 to order 1
		ResponseEntity<List<CustomerDTO>> exchange = retTemplate.exchange("http://localhost:8081/customer",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<CustomerDTO>>() {
				});
		System.out.println("********* customers with their acocunts " + exchange.getBody());

		// set customer 111 to order 1
		retTemplate.put("http://localhost:8082/order/1/customer/111", null, Void.class);

		// set credit card information to order 1
		retTemplate.put("http://localhost:8082/order/1/creditcard", new CreditCardDTO("33366555333888", new Date()),
				Void.class);

		// set Shipping option to order 1
		retTemplate.put("http://localhost:8082/order/1/shippingoption",
				new ShippingOptionDTO("Option1", 55, "shipper1"), Void.class);

		// set Shipping address to order 1
		retTemplate.put("http://localhost:8082/order/1/shippingAddress",
				new AddressDTO("shipping address1", "city1", 555, "USA"), Void.class);

		// set billing address to order 1
		retTemplate.put("http://localhost:8082/order/1/billingAddress",
				new AddressDTO("billing address1", "city2", 888, "USA"), Void.class);

		// retrieve order 3
		OrderDTO order = retTemplate.getForObject("http://localhost:8082/order/1", OrderDTO.class);
		System.out.println("***** " + order);

		// confirm order 1
		retTemplate.put("http://localhost:8082/order/1/confirm", null, Void.class);

	}

}
