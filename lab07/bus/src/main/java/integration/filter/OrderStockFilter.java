package integration.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;

import integration.model.Order;

/**
 * validate order items with the stock service
 * 
 * @author mbeshir
 *
 */
public class OrderStockFilter {

	@Autowired
	private RestOperations retTemplate;

	public boolean filter(Order order) {

		try {

			HttpEntity<Order> orderRequest = new HttpEntity<>(order);
			ResponseEntity<Void> postForEntity = retTemplate.postForEntity("http://localhost:8082/stock/ordervalidator",
					orderRequest, Void.class);
			return postForEntity.getStatusCode().equals(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("********** invalid order stock *******");
			return false;
		}

	}

}
