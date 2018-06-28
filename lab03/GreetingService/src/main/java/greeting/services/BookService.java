package greeting.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import greeting.models.Book;
import greeting.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;

	List<Book> books = new ArrayList<>();

	public void addBook(Book book) {
		bookRepository.save(book);

	}

	public void deleteBook(String isbn) {
		bookRepository.deleteById(isbn);

	}

	public Book getBook(String isbn) {
		return bookRepository.findById(isbn).orElse(null);

	}

	public List<Book> getAllBooks() {
		
		return bookRepository.findAll();

	}

}
