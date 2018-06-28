package greeting.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import greeting.models.Greeting;

@RestController
public class GreetingController {

	@RequestMapping("/greeting/{message}")
	public ResponseEntity<Greeting> getGreeting(@PathVariable() String message) {
		return new ResponseEntity<Greeting>(new Greeting(message), HttpStatus.OK);

	}

}
