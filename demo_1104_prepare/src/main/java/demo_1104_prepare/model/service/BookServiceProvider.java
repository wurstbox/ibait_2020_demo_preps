package demo_1104_prepare.model.service;

import java.util.Objects;

public class BookServiceProvider
{
	private static BookService current;

	public static BookService get()
	{
		Objects.requireNonNull(current);
		return current;
	}

	public static void set(BookService current)
	{
		BookServiceProvider.current = current;
	}	
}
