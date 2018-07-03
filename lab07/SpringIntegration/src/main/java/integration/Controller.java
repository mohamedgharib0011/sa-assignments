package integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	private GreetingGateway gateway;

	@RequestMapping("/greeting/{ordernumber}/{amount}")
	public ResponseEntity<Order> getGreeting(@PathVariable("ordernumber") String ordernumber,
			@PathVariable double amount) {
		Message<Order> helloMessage = MessageBuilder.withPayload(new Order(ordernumber, amount)).build();

		return new ResponseEntity<Order>(gateway.handleRequest(helloMessage), HttpStatus.OK);
	}
}
