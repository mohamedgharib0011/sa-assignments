package integration.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

import integration.model.Order;

/** 
 * 
 * @author mbeshir
 *
 */
@MessagingGateway
public interface OrderGateway {

	@Gateway(requestChannel = "orderInputChannel")
	void handleRequest(Message<Order> message);
}
