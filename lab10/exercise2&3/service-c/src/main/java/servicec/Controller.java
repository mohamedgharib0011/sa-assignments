package servicec;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicec")
public class Controller {


	@GetMapping
	public ResponseEntity<Void> name() throws InterruptedException {
		Thread.sleep(4000);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
