package payment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

	@PostMapping("payment/orderpayment/{customernumber}/{amount}")
	public ResponseEntity<Void> payOrder(@PathVariable String customernumber, @PathVariable double amount) {
		
		System.out.println("*************** order payment ********");
		return new ResponseEntity<Void>(amount < 200 ? HttpStatus.OK : HttpStatus.UNPROCESSABLE_ENTITY);
	}

}
