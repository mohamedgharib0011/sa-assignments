package order;

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

	/**  
	 *  
	 * @param message
	 */
	@KafkaListener(topics = "${app.topic.orderdelivered}")
	public void orderDeliveredEventHandler(@Payload String message) {
		System.out.println("Receiver.orderDeliveredEventHandler() message: " + message);
	}

	/** 
	 * 
	 * @param message
	 */
	@KafkaListener(topics = "${app.topic.productoutofstock}")
	public void productOutOfStockEventHandler(@Payload String message) {
		System.out.println("Receiver.productOutOfStockEventHandler() message: " + message);
	}
}
