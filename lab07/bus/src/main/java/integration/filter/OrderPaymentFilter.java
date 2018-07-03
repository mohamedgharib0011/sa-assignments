package integration.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;

import integration.model.Order;

/**
 * process payment with payment service
 * 
 * @author mbeshir
 *
 */
public class OrderPaymentFilter {

	@Autowired
	private RestOperations retTemplate;

	public boolean filter(Order order) {

		try {

			ResponseEntity<Void> postForEntity = retTemplate.postForEntity(
					"http://localhost:8083/payment/orderpayment/" + order.getOrdernumber() + "/" + order.getAmount(),
					null, Void.class);
			return postForEntity.getStatusCode().equals(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("********** invalid payment *******");
			return false;
		}
	}

}
