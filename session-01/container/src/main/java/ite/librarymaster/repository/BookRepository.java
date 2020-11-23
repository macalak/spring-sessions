package ite.librarymaster.repository;

import ite.librarymaster.model.Book;

import java.util.List;

/**
 * Book Repository interface defines operations to
 * access and manipulate Books.
 * 
 * @author macalak@itexperts.sk
 *
 */
public interface BookRepository {
	
	/**
	 * Finds all Books in the Library.
	 * @return - All books from Library
	 */
	List<Book> findAll();

	/**
	 * Find book according isbn number.
	 * @param isbn - book isbn number
	 * @return Book with given isbn, or null if no such book exists in the Library
	 */
	Book findByIsbn(String isbn);

}
