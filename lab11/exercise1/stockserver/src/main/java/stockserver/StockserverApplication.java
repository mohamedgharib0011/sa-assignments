package stockserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StockserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockserverApplication.class, args);
	}
}
