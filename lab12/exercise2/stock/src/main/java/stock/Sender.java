package stock;

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

	@Value("${app.topic.orderprepared}")
	private String orderPreparedTopic;

	@Value("${app.topic.productoutofstock}")
	private String productOutOfStockTopic;

	public void sendOrderPreparedEvent() {
		System.out.println("Sender.sendOrderPreparedEvent() send order prepared event");
		kafkaTemplate.send(orderPreparedTopic, "Order Prepared event");
	}

	public void sendProductOutOfStockEvent() {
		System.out.println("Sender.sendProductOutOfStockEvent() send product out of stock event");
		kafkaTemplate.send(productOutOfStockTopic, "Product out of stock event");

	}

}
