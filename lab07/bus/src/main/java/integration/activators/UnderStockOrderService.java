package integration.activators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestOperations;

import integration.model.Order;

/**
 * 
 * @author mbeshir
 *
 */
public class UnderStockOrderService {

	@Autowired
	private RestOperations retTemplate;

	public void receiveOrder(Order order) {
		try {
			System.out.println("UnderStockOrderService.receiveOrder() " + order);
			retTemplate.postForObject("http://localhost:8081/supplier/order", new HttpEntity<Order>(order), Void.class);

		} catch (Exception e) {
			System.out.println(" ************ order has been sent to suppplier *********");
		}
	}

}
