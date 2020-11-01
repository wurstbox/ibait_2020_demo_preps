package demo_1104_prepare.ui;

import demo_1104_prepare.model.books.Book;
import javafx.beans.property.SimpleStringProperty;

public class UIBook
{
	private final Book book;
	
	private final SimpleStringProperty authorName;
	private final SimpleStringProperty bookTitle;
	
	public UIBook(Book book)
	{
		this.book = book;
		this.authorName = new SimpleStringProperty(book.getAuthor().getName());
		this.bookTitle = new SimpleStringProperty(book.getTitle());
	}

	public Book getBook()
	{
		return book;
	}

	public SimpleStringProperty authorNameProperty()
	{
		return authorName;
	}

	public SimpleStringProperty bookTitleProperty()
	{
		return bookTitle;
	}
	
}
