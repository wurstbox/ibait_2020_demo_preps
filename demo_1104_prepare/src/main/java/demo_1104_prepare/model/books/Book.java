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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null)
		{
			if (other.author != null)
				return false;
		}
		else if (!author.equals(other.author))
			return false;
		if (title == null)
		{
			if (other.title != null)
				return false;
		}
		else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
