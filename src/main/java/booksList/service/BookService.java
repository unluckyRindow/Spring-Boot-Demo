package booksList.service;

import booksList.model.Book;
import booksList.model.User;
import booksList.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks(User user){
        return bookRepository.findByUser(user);
    }

    public void add(Book book, User user){
        book.setUser(user);
        bookRepository.save(book);
    }
}
