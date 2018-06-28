package greeting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import greeting.models.Book;
import greeting.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	BookService bookService;

	@PostMapping
	public ResponseEntity<Void> addBook(@RequestBody Book book) {
		bookService.addBook(book);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/{isbn}")
	public ResponseEntity<Void> deleteBook(@PathVariable String isbn) {
		bookService.deleteBook(isbn);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/{isbn}")
	public ResponseEntity<Book> getBook(@PathVariable String isbn) {
		return new ResponseEntity<Book>(bookService.getBook(isbn), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {
		return new ResponseEntity<List<Book>>(bookService.getAllBooks(), HttpStatus.OK);
	}

}
