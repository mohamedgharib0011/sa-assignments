package supplier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {

	@PostMapping("supplier/order")
	public ResponseEntity<Void> payOrder(@RequestBody Order order) {
		System.out.println("*************** supplier ********");

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
