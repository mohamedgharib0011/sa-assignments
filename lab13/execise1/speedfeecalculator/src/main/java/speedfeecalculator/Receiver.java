package speedfeecalculator;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import kafka.OverSpeedCar;

@Service
public class Receiver {

	@KafkaListener(topics = "abovespeedcarstopic")
	public void receive(@Payload OverSpeedCar SensorRecord, @Headers MessageHeaders headers) {
		System.out.println("received message=" + SensorRecord);
	}

}