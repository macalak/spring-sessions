package ite.librarymaster.web;

import ite.librarymaster.model.BookGenre;
import ite.librarymaster.service.ItemNotFoundException;
import ite.librarymaster.service.LibraryService;
import ite.librarymaster.web.model.Borrowing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/borrowing")
public class BorrowingController {
    final Logger logger = LoggerFactory.getLogger(BorrowingController.class);
    private static String BORROWING_VIEW="/borrowing/borrowing";
    private static String BORROWING_LINK="/borrowing/show";

	private Borrowing borrowing;
	private LibraryService libraryService;

	public BorrowingController(Borrowing borrowing, LibraryService libraryService) {
		this.borrowing = borrowing;
		this.libraryService = libraryService;
	}

	@RequestMapping(value="/show", method=RequestMethod.GET)
	public String show(Model model) {
	    logger.info("Show Borrowing ...");
	    model.addAttribute("borrowing", borrowing);
	    return BORROWING_VIEW;
	}

	 @RequestMapping(value = "/{id}/add", method = RequestMethod.GET)
	 public String processCreationForm(@PathVariable Long id) {
		logger.info("Adding Book with ID: {} to Borrowing",id);
		 try {
			 borrowing.getBooks().add(libraryService.getBook(id));
		 } catch (ItemNotFoundException e) {

		 }
		 return "redirect:" + BORROWING_LINK;
    }

}
