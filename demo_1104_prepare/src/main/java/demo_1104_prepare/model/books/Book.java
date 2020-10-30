package demo_1104_prepare.model.books;

public class Book
{
	private final Author author;
	private final String title;
	private int pages;
		
	public Book(Author author, String title, int pages)
	{
		this.author = author;
		this.title = title;
		this.pages = pages;
	}

	public int getPages()
	{
		return pages;
	}

	public void setPages(int pages)
	{
		this.pages = pages;
	}

	public Author getAuthor()
	{
		return author;
	}

	public String getTitle()
	{
		return title;
	}
	
}
