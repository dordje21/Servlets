package ee;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("/event")
public class EventExample extends HttpServlet {

    @Inject
    BookService bookService;
    @Inject
    Subscriber subscriber;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book one = new Book("one");
        bookService.addBook(one);
        bookService.addBook(new Book(" two "));
        bookService.removeBook(one);
        resp.getWriter().write(subscriber.bookList.size() + "");
    }
}


class Book {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book(String name) {
        this.name = name;
    }
}

class BookService {
    @Inject
    @Add
    Event<Book> add;
    @Inject
    @Remove
    Event<Book> remove;

    public void addBook(Book book) {
        System.out.println(book.getName() + " book added ");
        add.fire(book);
    }

    public void removeBook(Book book) {
        System.out.println(book.getName() + " book removed ");
        remove.fire(book);
    }
}

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD})
@interface Add {
}

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD})
@interface Remove {
}

@Singleton
class Subscriber {
    List<Book> bookList = new ArrayList<>();

    public void add(@Observes Book book) {
        System.out.println(book.getName() + " added to list ");
        bookList.add(book);
    }

    public void remove(@Observes Book book) {
        System.out.println(book.getName() + " remove of list ");
        bookList.remove(book);
    }
}