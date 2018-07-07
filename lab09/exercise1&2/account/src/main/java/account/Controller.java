package account;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("One")
public class Controller {

	@GetMapping("/account")
	public Account getAccount() {
		return new Account("123456", 100.0);
	}

}
