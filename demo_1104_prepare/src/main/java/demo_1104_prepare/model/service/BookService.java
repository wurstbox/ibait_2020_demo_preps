package demo_1104_prepare.model.service;

import java.util.List;

import demo_1104_prepare.model.books.Book;

public interface BookService
{
	List<Book> getBooks() throws ServiceException;
}


