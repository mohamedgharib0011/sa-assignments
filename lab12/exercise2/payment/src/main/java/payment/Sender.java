package payment;

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

	@Value("${app.topic.billedorder}")
	private String billedOrderTopic;

	public void sendBilledOrderEvent() {
		kafkaTemplate.send(billedOrderTopic, "Billed order event");
	}

}
