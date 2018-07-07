package account;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("Two")
public class ControllerTwo {

	@GetMapping("/account")
	public Account getAccount() {
		return new Account("123456", 200.0);
	}

}
