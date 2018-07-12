package speedchecker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import kafka.OverSpeedCar;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, OverSpeedCar> kafkaTemplate;

    public void send(String topic, OverSpeedCar sensorRecord){
        kafkaTemplate.send(topic, sensorRecord);
    }
}
