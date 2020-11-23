package ite.librarymaster.repository;

import ite.librarymaster.model.Book;

import java.util.List;

// TODO: Enable bean
// @Repository
// @DummyRepository
public class DummyBookRepository implements BookRepository {

	@Override
	public List<Book> findAll() {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public Book findByIsbn(String isbn) {
		throw new RuntimeException("Not implemented");
	}

}
