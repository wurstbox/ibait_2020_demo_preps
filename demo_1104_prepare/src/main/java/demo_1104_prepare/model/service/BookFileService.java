package demo_1104_prepare.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import demo_1104_prepare.model.books.Author;
import demo_1104_prepare.model.books.Book;

public class BookFileService implements BookService
{
	private final Map<String, Author> authors;
	
	
	public BookFileService()
	{
		this.authors = new HashMap<>();
	}

	
	@Override
	public List<Book> getBooks() throws ServiceException
	{
		var content = readFile();
		var books = convertToBooks(content);
		return books;
	}

	
	private List<String> readFile() throws ServiceException
	{
		var streamToBooksFile = getClass().getResourceAsStream("/data/books");
		BufferedReader reader = new BufferedReader(new InputStreamReader(streamToBooksFile));

		try (reader)
		{
			List<String> fileContent = new LinkedList<String>();

			String readLine = "";

			while ((readLine = reader.readLine()) != null)
			{
				fileContent.add(readLine);
			}

			return fileContent;
		}
		catch (IOException e)
		{
			throw new ServiceException("Books file could not be read");
		}
	}

	
	private List<Book> convertToBooks(List<String> content) throws ServiceException
	{
		try
		{
			List<Book> books = new ArrayList<Book>(content.size());

			for (String bookLine : content)
			{
				var splitContent = bookLine.split("\t");
				
				var author = this.authors.computeIfAbsent(
						splitContent[0],
						s -> new Author(s));
				var title = splitContent[1];
				var pages = Integer.valueOf(splitContent[2]);

				var book = new Book(author, title, pages);

				books.add(book);
			}

			return books;
		}
		catch (NullPointerException | ArrayIndexOutOfBoundsException e)
		{
			throw new ServiceException("Books file corrupted");
		}
	}

}
