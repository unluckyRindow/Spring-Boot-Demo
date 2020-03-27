package booksList.web;

import booksList.model.Book;
import booksList.model.User;
import booksList.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private BookService bookService;

    @Autowired
    public MainController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method=RequestMethod.GET, value="/fail")
    public void fail() {
        throw new RuntimeException();
    }

    @ExceptionHandler(value=RuntimeException.class)
    @ResponseStatus(value= HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
    public String error() {
        return "error";
    }

    @GetMapping()
    public String showUserBooks(User user, Model model) {
        List<Book> booksList = bookService.findAllBooks(user);
        if (booksList != null) {
            model.addAttribute("books", booksList);
            model.addAttribute("user", user);
        }
        return "booksList";
    }

    @PostMapping()
    public String addToReadingList(User user, Book book) {
        bookService.add(book, user);
        return "redirect:/";
    }
}