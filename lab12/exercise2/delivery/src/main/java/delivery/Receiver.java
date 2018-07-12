package delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * container for event handlers
 * 
 * @author mbeshir
 *
 */
@Component
public class Receiver {

	@Autowired
	private Sender sender;

	/**
	 * 
	 * @param message
	 */
	@KafkaListener(topics = "${app.topic.orderprepared}")
	public void orderPreparedEventHandler(@Payload String message) {
		System.out.println("Receiver.orderPreparedEventHandler() message: " + message);
		sender.sendOrderDeliveredEvent();
	}

}
