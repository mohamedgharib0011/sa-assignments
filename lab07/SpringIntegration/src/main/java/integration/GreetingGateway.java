package integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface GreetingGateway {

	@Gateway(requestChannel = "warehouseInputChannel")
	Order handleRequest(Message<Order> message);
}
