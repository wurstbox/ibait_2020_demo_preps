package demo_1104_prepare.model.service;

import java.util.LinkedList;
import java.util.List;

import demo_1104_prepare.model.books.Author;
import demo_1104_prepare.model.books.Book;

public class BookMockService implements BookService
{

	@Override
	public List<Book> getBooks() throws ServiceException
	{
		List<Book> books = new LinkedList<>();
		
		Author mueller = new Author("Müller");
		Author albrecht = new Author("Albrecht");

		books.add( new Book( mueller, "Mein Leben bis 12", 57 ) );
		books.add( new Book( mueller, "Meine Lehrjahre", 837 ) );
		books.add( new Book( albrecht, "Sommersonnenwende", 311 ) );
				
		return books;
	}

}

