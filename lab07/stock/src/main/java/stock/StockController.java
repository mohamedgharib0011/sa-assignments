package stock;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

	@PostMapping("stock/ordervalidator")
	public ResponseEntity<Void> payOrder(@RequestBody Order order) {
		System.out.println("*************** ordervalidator ********");
		return new ResponseEntity<Void>(order.getOrderlines().size() < 3 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

}
