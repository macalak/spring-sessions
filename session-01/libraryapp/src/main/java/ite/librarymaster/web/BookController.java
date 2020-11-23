package ite.librarymaster.web;

import java.util.Arrays;
import java.util.List;

import ite.librarymaster.model.Book;
import ite.librarymaster.model.BookGenre;
import ite.librarymaster.service.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.*;


/**
 * A Spring MVC @Controller controller handling requests related to Books.
 * Flow:
 * 		GET  /book/all        -- returns --> view book/books (books.html)	
 *      GET  /book/{id}       -- returns --> view book/book  (book.html)
 *      GET  /book/add        -- returns --> view book/edit_book  (edit_book.html)
 *      GET  /book/{id}/edit  -- returns --> view book/edit_book  (edit_book.html)
 *      POST /book/add        -- returns --> view book/books  (books.html)
 *      POST /book/{id}/edit  -- returns --> view book/books  (books.html) 
 */
@Controller
@RequestMapping("/book")
public class BookController {
    final Logger logger = LoggerFactory.getLogger(BookController.class);
    private static String BOOKS_VIEW="/book/books";
    private static String BOOKS_LINK="/book/all";
    private static String BOOK_DETAIL_VIEW="/book/book";
    private static String BOOK_EDIT_VIEW="/book/edit_book";
	
	private LibraryService libraryService;
	
	@Autowired
	public BookController(LibraryService libraryService) {
		super();
		this.libraryService = libraryService;
	}
	
	@ModelAttribute("genres")
    public List<BookGenre> populateBookGenres() {
		logger.info("Populating Book genres...");
        return  Arrays.asList(BookGenre.values());
    }
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public String allBook(Model model) {
	    logger.info("Retrieving all Books...");
	    model.addAttribute("books", libraryService.getAllBooks());
	    return BOOKS_VIEW;
	}

	// TODO: Error case handling implementation
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String bookDetail(@PathVariable Long id, Model model) throws ItemNotFoundException{
	    logger.info("Retrieving Book with ID:{}...",id);
	    model.addAttribute("book",libraryService.getBook(id));
	    return BOOK_DETAIL_VIEW;
	}

	
	 // TODO: Error case handling implementation 
	 // TODO: Add validation
	 @RequestMapping(value = "/add", method = RequestMethod.POST)
	 public String processCreationForm(@ModelAttribute("book") Book book, SessionStatus status) {
		logger.info("Adding Book with ISBN: {}...",book.getIsbn());
		libraryService.saveBook(book);
        return "redirect:"+BOOKS_LINK;
    }

	// TODO: Error case handling implementation 
	 // TODO: Add validation
	 @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	 public String processUpdateForm(@ModelAttribute("book") Book book, SessionStatus status) {
		 logger.info("Updating Book with ISBN: {}...",book.getIsbn());
		 libraryService.saveBook(book);
         return "redirect:"+BOOKS_LINK;
     }
	
	
	/*
	 * Book editing Form initialization for new book creation.
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public String initCreationForm(Model model) {
		logger.info("Creating new Book instance...");
        Book newBook = new Book();
        model.addAttribute("book", newBook);
        return BOOK_EDIT_VIEW;
    }

	/*
	 * Book editing Form initialization for existing book update.
	 */
	// TODO: Error case handling implementation
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String initUpdateForm(@PathVariable("id") Long bookId, Model model) throws ItemNotFoundException {
		logger.info("Finding book with ID: {} for update...", bookId);
        Book book = libraryService.getBook(bookId);
        model.addAttribute("book", book);
        return BOOK_EDIT_VIEW;
    }
}
