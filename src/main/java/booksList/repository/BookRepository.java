package booksList.repository;

import java.util.List;

import booksList.model.Book;
import booksList.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByUser(User user);
}
