package speedchecker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import kafka.OverSpeedCar;
import kafka.SensorRecord;

@Service
public class Receiver {

	@Autowired
	private Sender sender;

	@KafkaListener(topics = { "cameratopic1", "cameratopic2" })
	public void receive(@Payload SensorRecord SensorRecord, @Headers MessageHeaders headers) {
		double speed = SensorRecord.getSpeed();
		if (speed > 72)
			sender.send("abovespeedcarstopic", new OverSpeedCar(SensorRecord.getLicencePlate(), speed));
	}

}