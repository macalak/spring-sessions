package ite.librarymaster.service;

import static org.junit.Assert.*;
import ite.librarymaster.model.*;

import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;


/**
 * This test verifies functionality of LibraryService implementation.
 * 
 * @author macalak@itexperts.sk
 *
 */
@ContextConfiguration(value="classpath:application-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class LibraryServiceSpringTest {
	
	/**
	 * The object being tested.
	 */
	@Autowired
	private LibraryService libraryService;
	
	@Test
	public void testGetAllBooks() {
		List<Book> allBooks = libraryService.getAllBooks();
		assertNotNull(allBooks);
		assertEquals(4,allBooks.size());
	}
}
