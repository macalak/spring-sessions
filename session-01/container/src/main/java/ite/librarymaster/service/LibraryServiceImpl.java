package ite.librarymaster.service;

import ite.librarymaster.repository.BookRepository;
import ite.librarymaster.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

// @Service
public class LibraryServiceImpl implements LibraryService{
	private final static Logger LOG = LoggerFactory.getLogger(LibraryServiceImpl.class);
	
	private BookRepository bookRepository;

	public LibraryServiceImpl() {
		LOG.info("Constructor <-");
	}

	@Override
	public List<Book> getAllBooks() {
		LOG.info("Looking for all books...");
		return bookRepository.findAll();
	}

	@Override
	public Book findByIsbn(String isbn) {
		LOG.info("Looking for Book by ISBN:{}...",isbn);
		return bookRepository.findByIsbn(isbn);
	}

	// @InMemoryRepository
	public void setBookRepository(BookRepository bookRepository) {
		LOG.info("setBookRepository() <-");
		this.bookRepository = bookRepository;
	}

}
