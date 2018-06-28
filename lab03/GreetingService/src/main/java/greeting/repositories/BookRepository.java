package greeting.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import greeting.models.Book;

public interface BookRepository extends MongoRepository<Book, String>{

}
