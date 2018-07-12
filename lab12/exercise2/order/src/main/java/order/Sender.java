package order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value("${app.topic.ordercreated}")
	private String orderCreatedTopic;

	public void sendOrderCreatedEvent() {
		System.out.println("Sender.sendOrderCreatedEvent() sending order created event");
		kafkaTemplate.send(orderCreatedTopic, "Order created successfully");
	}

}
