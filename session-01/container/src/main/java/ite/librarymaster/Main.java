package ite.librarymaster;

import java.util.List;

import ite.librarymaster.model.Book;
import ite.librarymaster.service.LibraryService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.*;

/**
 * Application entry point.
 * 
 * @author macalak@itexperts.sk
 *
 */

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-config.xml");
       //ApplicationContext context = new AnnotationConfigApplicationContext("ite.librarymaster");

		// Register shutdown hook to destroy container gracefully
        ((AbstractApplicationContext)context).registerShutdownHook();
		LibraryService libraryService=context.getBean(LibraryService.class);
		List<Book> books = libraryService.getAllBooks();
		for(Book book:books){
			System.out.println(book);
		}
	}
}
