package servicea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/servicea")
public class Controller {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping
	@HystrixCommand(fallbackMethod = "handleCallServiceB", threadPoolKey = "servicebThreadPool", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "5"),
			@HystrixProperty(name = "coreSize", value = "2") }, commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000") })
	public ResponseEntity<Void> name() throws InterruptedException {
		restTemplate.getForObject("http://localhost:7081/serviceb", Void.class);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	public ResponseEntity<Void> handleCallServiceB() {
		System.out.println("************** service B not reponse");
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
