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

	@Override
	public int hashCode()
	{
		int result = 0;

		if (this.name != null)
		{
			result = name.length();
		}
	}

	@Override
	public boolean equals(Object obj)
	{
		boolean result;
		
		if (obj == null)
			result = false;
		else if(this == obj)
			result = true;
		else if( this.getClass() != obj.getClass())
			result = false;
		else
		{
			Author that = (Author) obj;
			result = Objects.equals(this.name, that.name);
		}
		
		return result;
	}

}
