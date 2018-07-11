package stockclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class StockclientApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StockclientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Flux<String> bodyToFlux = WebClient.create("http://localhost:8080/customers").get().retrieve().bodyToFlux(String.class);
		bodyToFlux.subscribe(x->System.out.println("*********** value :"+x));
		
	}
}
