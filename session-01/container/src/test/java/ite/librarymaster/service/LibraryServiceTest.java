package ite.librarymaster.service;

import ite.librarymaster.model.Book;
import ite.librarymaster.repository.InMemoryBookRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * This test verifies functionality of LibraryService implementation.
 * 
 * @author macalak@itexperts.sk
 *
 */
public class LibraryServiceTest {
	final private static Logger LOG = LoggerFactory.getLogger(LibraryServiceTest.class);
	
	private LibraryService libraryService = null;
	private ApplicationContext context = null;


	@Before
	public void init(){
		LOG.info("Test setup");
		context = new ClassPathXmlApplicationContext("classpath:application-config.xml");
		libraryService = context.getBean(LibraryService.class);
	}

	@After
	public void tearDown(){
		LOG.info("Test teardown");
		((AbstractApplicationContext)context).close();
	}
	
	@Test
	public void testGetAllBooks() {
		List<Book> allBooks = libraryService.getAllBooks();
		assertNotNull(allBooks);
		assertEquals(4,allBooks.size());
	}
}
