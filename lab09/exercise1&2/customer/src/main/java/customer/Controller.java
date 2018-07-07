package customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {

	@Autowired
	AccountFeignClient accountFeignClient;

	@GetMapping("/")
	public Account getCustomer() {
		return accountFeignClient.getAccount();
	}

	@FeignClient("accountService")
	@RibbonClient(name="accountService")
	interface AccountFeignClient {

		@RequestMapping("/account")
		public Account getAccount();

	}

}
