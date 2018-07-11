package stockserver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class Controller {

	Flux<String> products = Flux.empty();

	@GetMapping(value = "/customers", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> getRunning() {
		Flux<String> r = Flux.just("" + System.currentTimeMillis());
		return r;

	}

}
