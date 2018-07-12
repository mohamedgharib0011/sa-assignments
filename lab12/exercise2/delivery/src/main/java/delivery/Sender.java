package delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * 
 * @author mbeshir
 *
 */
@Component
public class Sender {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value("${app.topic.orderdelivered}")
	private String orderDeliveredTopic;


	public void sendOrderDeliveredEvent() {
		System.out.println("Sender.sendOrderDeliveredEvent() send order delivered event");
		kafkaTemplate.send(orderDeliveredTopic, "Order delivered event");
	}

}
