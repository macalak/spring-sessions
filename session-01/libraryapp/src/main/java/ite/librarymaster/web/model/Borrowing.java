package ite.librarymaster.web.model;

import ite.librarymaster.model.Book;
import ite.librarymaster.web.BookController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Borrowing backing bean
 */
public class Borrowing {
    final Logger LOG = LoggerFactory.getLogger(Borrowing.class);

    private Set<Book> books = new HashSet<>();

    public Borrowing() {
        LOG.info("Constructor <-");
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
