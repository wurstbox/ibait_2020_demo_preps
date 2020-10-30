package demo_1104_prepare.model.books;

import java.util.ArrayList;
import java.util.Objects;

public class Author
{
	private final String name;
	private ArrayList<Book> books;

	public Author(String name)
	{
		this.name = name;
		this.books = new ArrayList<>();
	}

	public String getName()
	{
		return name;
	}

	public ArrayList<Book> getBooks()
	{
		return books;
	}

	public void setBooks(ArrayList<Book> books)
	{
		this.books = books;
	}

}
