package serviceb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/serviceb")
public class Controller {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping
	public ResponseEntity<Void> name() throws InterruptedException {
		restTemplate.getForObject("http://localhost:7080/servicec", Void.class);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
